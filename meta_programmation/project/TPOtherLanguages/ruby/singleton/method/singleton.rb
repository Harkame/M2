# Author : Louis Daviaud
# Define simple Class to explain ruby's concept, singleton's method
class MyObject
  # Default constructor
  def initialize
  end
end

# Creation of 2 objects

my_object = MyObject.new

my_other_object = MyObject.new

# Define singleton method 'foo' for object/variable 'singleton'
# This is an classic method for MyObject, but only defined for 'my_object_object' object/variable.
def my_object.foo
     'Singleton method of object my_object'
end

# Same, for my_other_object
def my_other_object.bar
     'Singleton method of object my_other_object'
end

puts my_object.foo

# puts other_singleton.foo # Error, method undefined

puts my_other_object.bar
