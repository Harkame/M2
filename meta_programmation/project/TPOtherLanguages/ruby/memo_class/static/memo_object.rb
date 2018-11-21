# Class who contains instances
class MemoObject
  @@instances = [] #List of instances (static)

  # Default initializer
  # Store self into instances
  def initialize
    @@instances << self
  end

  ## Getter - instances
  def self.all_instances
    @@instances
  end
end

# An subclass of MemoObject
class Person < MemoObject

  # Initializer with parameters (name, age)
  def initialize name, age
    super()
    @name = name
    @age = age
  end
end

# Test

# Creation of 3 persons
p1 = Person.new "Titi", 12
p2 = Person.new "Toto", 78
p3 = Person.new "Tata", 42

# Show stored instances from MemoObject
puts MemoObject.all_instances
