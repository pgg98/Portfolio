if ((ssRoll != undefined) and (ssRoll.isdisplayed)) do 
	(destroyDialog ssRoll)

rollout ssRoll "Solar System" 
	(
		group "Modo Creador"
		(
			spinner spn_sunRadius "Radio del sol" range:[1,1000,50]
			button but_createSun "Crear sol" 
			spinner spn_numPlanets "Número de Planetas" type:#integer range:[1,10,3]
			button but_createPlanets "Crear Planetas" 
		)
		group "Grupo de Planetas" 
		(
			pickbutton pbt_pickPlanet "Elegir Planeta" 
			spinner spn_planetRadius "Radio del planeta" 
			spinner spn_orbitRadius "Radio de la Órbita" range:[0,1000,0]

		)
		on but_createSun pressed do 
			( 
				sun = sphere radius:spn_sunRadius.value
			) 
		on but_createSun rightclick do 
			( 
				sun = geosphere radius:spn_sunRadius.value
			)
		on but_createPlanets pressed do 
			( 
				for i = 1 to spn_numPlanets.value do
					( 
						-- Create the planet 
						planet = sphere() -- Create the planet 
						-- Set planet radius to a random number between 10 and 30
						planet.radius = random 10.0 30.0 
						-- Create a circle for the planet's orbit 
						orbit = circle radius:(i*100) 
						-- Put the planet on a path 
						planet.pos.controller = Path_Constraint() 
						planet.pos.controller.path = orbit 
						-- Rotate the path so its 0 position is random 
						orbit.rotation.z_rotation = random 0.0 360.0 
					) 
			)
			--CAMBIAR RADIO PLANETA
			local pPlanet
			local pOrbit
		on pbt_pickPlanet picked aPlanet do
		(
			pPlanet = aPlanet
			-- Put the picked planet’s radius in the Planet Radius spinner 
			spn_planetRadius.value = aPlanet.radius
			-- Put the orbit’s radius in the Orbit Radius spinner
			pOrbit = aPlanet.pos.controller.path
			spn_orbitRadius.value = pOrbit.radius
		)
		on spn_planetRadius changed value do 
			( 
				pPlanet.radius = spn_planetRadius.value
			)
		on spn_orbitRadius changed value do 
			( 
				pOrbit.radius = spn_orbitRadius.value 
			)
	) 
		createDialog ssRoll 200 300

		