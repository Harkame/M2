# Class who contains instances
class MemoObject
  @@instances = [] #List of instances (static)

  # Default initializer
  # Store self into instances
  def initialize
    @@instances << self
  end

  ## Getter - instances
  @ return [Array] All stored instances
  def self.getInstances
    @@instances
  end
end

# Class Person is an subclass of MemoObject
class Person < MemoObject

  # Initializer with parameters
  # @param [Object] name The name of the person
  # @param [Object] age The age of the person
  def initialize name, age
    @name = name
    @age = age
  end
end

# Main

# Creation of 3 persons
p1 = Person.new "Titi", 12
p2 = Person.new "Toto", 78
p3 = Person.new "Tata", 42

# Show stored instances from MemoObject
puts MemoObject.getInstances
