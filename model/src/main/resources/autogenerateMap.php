<?php
	$handle = fopen('./carte.txt', 'r');
	if ($handle) {
		$x = 0;

		while (!feof($handle)){
			$buffer = fgets($handle);
			$index = 0;
			while($index < 20){
				if($buffer[$index] != " "){
					echo "INSERT INTO element VALUES (NULL, '1', '".$buffer[$index]."', '$index','$x');\n";
				}
				$index++;
			}
			$x++;
		}


	}
?>