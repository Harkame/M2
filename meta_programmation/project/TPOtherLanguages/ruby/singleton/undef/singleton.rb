class Singleton
  class << self #Now, we work directly on class Singleton
    undef_method :new #"remove" method new, now we can't instanciate an Singleton

    #Class method
    def foo1
      puts "foo1"
    end
  end

  #Instance method
  def self.foo2
    puts "foo2"
  end
end

puts Singleton

puts Singleton.singleton_methods

puts Singleton.inspect
