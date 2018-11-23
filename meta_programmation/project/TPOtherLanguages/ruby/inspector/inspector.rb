# This module is used to format output
module Util
  @@lineSeparator = "-----------------------"

  def self.get_line_separator
    @@lineSeparator
  end
end

# Class who inspect other object
class Inspector
  # This method is called to inspect an object
  # It call inspect_instance
  # @param [Object] object_to_inspect The object to inspect
  def inspect_object object_to_inspect
    inspect_instance object_to_inspect, object_to_inspect.class
  end

  # This method is call to inspect an instance + class
  # It call all of the inspect methods
  # @param [Object] object_to_inspect The instance to inspect
  # @param [Class] object_to_inspect_class The class of inspected object
  def inspect_instance object_to_inspect, object_to_inspect_class
    inspect_hierarchy object_to_inspect, object_to_inspect_class

    puts "Class methods"
    inspect_public_methods object_to_inspect_class
    inspect_private_methods object_to_inspect_class

    puts "Object methods"
    inspect_public_methods object_to_inspect
    inspect_private_methods object_to_inspect

    puts "Attributs"
    inspect_class_attributs object_to_inspect_class
    inspect_object_attributs object_to_inspect
  end

  # Inspect hierarchy of the inspected object
  # @param [Object] object_to_inspect
  # @param [Class] object_to_inspect_class
  def inspect_hierarchy(object_to_inspect, object_to_inspect_class)
    puts "#{object_to_inspect} instance of \"#{object_to_inspect_class.name}\""

    print "Hierarchy : "
    object_to_inspect_class.ancestors.each do |ancestor|
      print "#{ancestor} -> "
    end
    puts
    puts "#{Util::get_line_separator}"
  end

  # Inspect public methods of inspected object
  # @param object_to_inspect
  def inspect_public_methods(object_to_inspect)
    puts "- Public methods :"
    object_to_inspect.public_methods(false).each do |method|
      puts "\t- #{method} "
    end
    puts "#{Util::get_line_separator}"
  end

  # Inspect private methods of inspected object
  # @param object_to_inspect
  def inspect_private_methods(object_to_inspect)
    puts "- Private methods :"
    object_to_inspect.private_methods(false).each do |method|
      puts "\t- #{method}"
    end
    puts "#{Util::get_line_separator}"
  end

  # Inspect class attributs of inspected object
  # @param class_to_inspect
  def inspect_class_attributs(class_to_inspect)
    puts "- Class attributs :"
    class_to_inspect.class_variables.each do |attribute|
      value = class_to_inspect.class_eval attribute.to_s
      puts "\t- Name  : #{attribute}"
      puts "\t\t- Type  : #{value.class}"
      puts "\t\t- Value : #{value.inspect}"
    end
    puts "#{Util::get_line_separator}"
  end

  # Inspect object attributs of inspected object
  # @param object_to_inspect
  def inspect_object_attributs(object_to_inspect)
    puts "- Instance attributs :"
    object_to_inspect.instance_variables.each do |attribute|
      value = object_to_inspect.instance_eval attribute.to_s
      puts "\t- Name  : #{attribute}"
      puts "\t\t- Type  : #{value.class}"
      puts "\t\t- Value : #{value.inspect}"
    end
    puts "#{Util::get_line_separator}"
  end

  # Private methods
  private :inspect_hierarchy
  private :inspect_public_methods
  private :inspect_private_methods
  private :inspect_class_attributs
  private :inspect_object_attributs
end

# Class to inspect
class Person
  # Static attributs
  @@default_name = "Toto"
  @@default_age = 42

  # Initializer with parameters
  # @param [Object] name The name of the person
  # @param [Object] age The age of the person
  def initialize name, age
    @name = name
    @age = age
  end

  # Print foo
  def foo
    puts "foo"
  end
end

# Main

# Creation of 2 persons
person1 = Person.new "Tata", 29
person2 = Person.new "Titi", 42

inspector = Inspector.new

# Inspection of person1
inspector.inspect_object person1

# Some format
puts "#{Util::get_line_separator}"
puts "#{Util::get_line_separator}"
puts "#{Util::get_line_separator}"

inspector.inspect_object person2
