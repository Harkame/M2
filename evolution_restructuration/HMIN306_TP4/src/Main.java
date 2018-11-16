import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TypeDeclaration;

 
public class Main {
	
	public static void main(String args[]) throws IOException{
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		
		//parser.setSource("public class A { int i = 9;  \n int j; \n ArrayList<Integer> al = new ArrayList<Integer>();j=1000; }".toCharArray());
		parser.setSource(readFileToString("/auto_home/ldaviaud/workspace/JapscanDownloader/src/fr/harkame/japscandownloader/downloader/JapscanDownloader.java").toCharArray());
		//parser.setSource("/*abc*/".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		//ASTNode node = parser.createAST(null);
 
 
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
 
		cu.accept(new ASTVisitor() {
 
			Set<String> names = new HashSet<String>();
			
			public boolean visit(TypeDeclaration node) {
				
				SimpleName name = node.getName();
				
				this.names.add(name.getIdentifier());
				
				System.out.println("Class :  " + node.getName() + " - " + node.modifiers());
				
				System.out.println("Superclass : ");
				for(Object object : node.superInterfaceTypes())
				{
					System.out.println("toto");
					System.out.println(object);
				}
				
				System.out.println("---");
					
				for(FieldDeclaration fieldDeclaration : node.getFields())
					System.out.println(fieldDeclaration.fragments().get(0) + " - " + fieldDeclaration.modifiers().toString());
				
				System.out.println("---");

				for(MethodDeclaration methodDeclaration : node.getMethods())
					System.out.println(methodDeclaration.getName() + " - " + methodDeclaration.getReturnType2() + " - " + methodDeclaration.parameters());
				
				return false;
			}
		});
	}
	
	
	//read file content into a string
		public static String readFileToString(String filePath) throws IOException {
			StringBuilder fileData = new StringBuilder(1000);
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
	 
			char[] buf = new char[10];
			int numRead = 0;
			while ((numRead = reader.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
	 
			reader.close();
	 
			return  fileData.toString();	
		}

}