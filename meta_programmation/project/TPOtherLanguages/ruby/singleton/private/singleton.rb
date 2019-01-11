class Singleton
  @@instance = Singleton.new #The singleton object

  # Default contrcturo
  def initialize
  end

  # Getter - instance
  def self.instance
    @@instance
  end

  private_class_method :new #Hide method new, now we can't instanciate an Singleton
end

singleton = Singleton.instance

other_singleton = Singleton.new # Error, private method new
