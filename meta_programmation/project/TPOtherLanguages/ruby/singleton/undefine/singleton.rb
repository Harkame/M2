# Class Singleton, who cannot be instanciate (only 1 instance)
# In this example, we gonna 'remove', undefine method 'new' to block instanciation
class Singleton
  @@instance = Singleton.new #The singleton object

  # Default contrcturo
  def initialize
  end

  # Getter - instance
  def self.instance
    @@instance
  end

  class << self # Now, we work directly on class Singleton
    undef_method :new # 'remove' method 'new', now we can't instanciate an Singleton, its important to make this call after instanciation of attribut @@instance
  end
end

singleton = Singleton.instance

# other_singleton = Singleton.new # Error, private method new
