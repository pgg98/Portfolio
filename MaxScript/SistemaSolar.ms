 rollout ssRoll "Sistema Solar" (
	 spinner spn_sunRadius "Radio del Sol" 
	 button but_createSun "Crear Sol" 
	 spinner spn_numPlanets "Numero de planetas" 
	 button but_createPlanets "Crear planetas" 
	 group "Planetas"(
		 pickbutton pbt_pickPlanet "Elegir Planeta" 
	 spinner spn_planetRadius "Radio Planeta" 
	 spinner spn_orbitRadius "Radio Orbita" )
	 )
createDialog ssRoll 200 200
	 
	 on but_createSun pressed do ( sun = sphere radius:spn_sunRadius.value )