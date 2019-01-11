# Author : Louis Daviaud
# Class Singleton, who cannot be instanciate (only 1 instance)
# In this example, we gonna 'hide' method new to block instanciation
class Singleton
  @@instance = Singleton.new #The singleton object

  # Default contrcturo
  def initialize
  end

  # Getter - instance
  def self.instance
    @@instance
  end

  private_class_method :new # Hide method 'new' outside this Class, now we can't instanciate an Singleton, its important to make this call after instanciation of attribut @@instance
end

singleton = Singleton.instance

# other_singleton = Singleton.new # Error, private method new
