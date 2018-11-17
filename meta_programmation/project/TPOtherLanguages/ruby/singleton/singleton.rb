class Singleton

  class << self

    undef_method :new

    def foo1
      puts "foo1"
    end
  end

  def self.foo2
    puts "foo2"
  end
end

puts Singleton

puts "--"

puts Singleton.singleton_methods

puts "--"

puts Singleton.inspect

h = class << Singleton; self; end

puts h.inspect
