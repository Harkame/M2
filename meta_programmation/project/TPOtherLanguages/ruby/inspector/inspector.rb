class Inspector
  def initialize
    @@lineSeparator = "---------------------------------------------------------------------"
  end

  def self.getLineSeparator
    @@lineSeparator
  end

  def inspect_object objectToInspect
    inspect_instance objectToInspect, objectToInspect.class
  end

  def inspect_instance objectToInspect, objectToInspectClass
    puts
    puts "#{objectToInspect} instance of \"#{objectToInspectClass.name}\""
    puts "Meta class : #{objectToInspect.singleton_class}, #{objectToInspectClass.singleton_class}"
    puts "#{@@lineSeparator}"
    print "Hierarchy : "
    objectToInspectClass.ancestors.each do |ancestor|
      print "#{ancestor} -> "
    end
    puts "\n---------------------------------------------------------------------"

    puts "Class attributs \"#{objectToInspectClass.name}\" :"
    objectToInspectClass.class_variables.each do |attribute|
      inspect_class_attribute attribute, objectToInspectClass
    end

    puts "Instance attributs \"#{objectToInspect}\" :"
    objectToInspect.instance_variables.each do |attribute|
      inspect_instance_attribute attribute, objectToInspect
    end

    puts "#{@@lineSeparator}"

    puts "Class methods \"#{objectToInspectClass.name}\" :"
    puts "- Private :"
    objectToInspectClass.private_methods(false).each do |method|
      puts "\t-#{method}"
    end
    puts "- Public :"
    objectToInspectClass.public_methods(false).each do |method|
      puts "\t- #{method}"
    end

    puts "#{@@lineSeparator}"

    puts "Object methods \"#{objectToInspect}\" :"
    puts "- Private :"
    objectToInspect.private_methods(false).each do |method|
      puts "\t- #{method}"
    end
    puts "- Public :"
    objectToInspect.public_methods(false).each do |method|
      puts "\t- #{method} "
    end
  end

  def inspect_class_attribute attribute, objectToInspectClass
    value = objectToInspectClass.class_eval attribute.to_s
    puts "- #{attribute}, #{value.class}, valeur : #{value.inspect}"
  end
  
  def inspect_instance_attribute attribute, objectToInspect
    value = objectToInspect.instance_eval attribute.to_s
    puts "\t- #{attribute}, #{value.class}, valeur : #{value.inspect}"
  end
end

class Person
  def initialize name, age
    super()
    @name = name
    @age = age
  end

  def foo
    puts "foo"
  end
end

person1 = Person.new "Tata", 29
person2 = Person.new "Titi", 42

inspector = Inspector.new

inspector.inspect_object person1

puts "#{Inspector.getLineSeparator}"
puts "#{Inspector.getLineSeparator}"
puts "#{Inspector.getLineSeparator}"

inspector.inspect_object person2
