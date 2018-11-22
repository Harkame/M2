<?php

class Hello
{

    function Hello($name)
    {
        $this->name = $name;
    }
    
    function hello2Me()
    {
        return 'Hello ' . $this->name;
    }
}

$hello = new Hello('Guillaume');
echo $hello->hello2Me();

?>
