# Author : Louis Daviaud
# Class who can remember her instances
class MemoObject
  @@instances = [] #List of instances (static)

  # Default constructor
  # Store self (new object) into instances
  def initialize
    @@instances << self
  end

  # Getter - instances
  # @ return [Array] All stored instances
  def self.getInstances
    @@instances
  end
end

# Class Person is an subclass of MemoObject
class Person < MemoObject
  # Constructor with parameters
  # @param [Integer] name The name of the person
  # @param [String] age The age of the person
  def initialize name, age
    super()
    @name = name
    @age = age
  end
end

# Creation of 3 persons
p1 = Person.new 'Titi', 12
p2 = Person.new 'Toto', 78
p3 = Person.new 'Tata', 42

puts 'Stored instance(s) :'

# Show stored instances from MemoObject
puts MemoObject.getInstances
