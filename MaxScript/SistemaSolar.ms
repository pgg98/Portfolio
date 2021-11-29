if ((ssRoll != undefined) and (ssRoll.isdisplayed)) do 
	(destroyDialog ssRoll)
	
rollout ssRoll "Sistema Solar" 
	(
		group "Modo Creador"
		(
			spinner spn_sunRadius "Radio del sol" range:[1,1000,50]
			button but_createSun "Crear sol" 
			spinner spn_numPlanets "Número de Planetas" type:#integer range:[1,10,3]
			button but_createPlanets "Grupo de Planetas Órbitas circulares" 
			button but_createPlanetsElip "Grupo de Planetas Órbitas elípticas" 
		)
		group "Grupo de Planetas" 
		(
			pickbutton pbt_pickPlanet "Elegir Planeta" 
			spinner spn_planetRadius "Radio del planeta" 
			spinner spn_orbitRadius "Radio de la Órbita" range:[0,1000,0]
			pickbutton pbt_destruir"Borrar Planeta"
			colorpicker theColor "Cambiar color planeta:" color:[0,0,255] modal:false
		)
		group "Satélites" 
		(
			pickbutton pbt_pickPlanetSat "Elegir Planeta para crear Sat"
			colorpicker colorsat "Cambiar color Satelite:" color:[0,0,255] modal:false

		)
		group "Explosiones"
		(
			button disparo "Explotar el Sol"
		)
		on but_createSun pressed do 
			( 
				sun = sphere radius:spn_sunRadius.value isSelected:on
				sun.wirecolor = yellow
					$.name="fuente"
			)
		on but_createPlanets pressed do 
			( 
				for i = 1 to spn_numPlanets.value do
					( 
						-- Crear planeta
						planet = sphere() 
						-- Establecer radio
						planet.radius = random 10.0 30.0 
						planet.wirecolor = color (random 0 255) (random 0 255) (random 0 255)
						-- Crear órbita circular
						orbit = circle radius:(i*100) 
						orbit.wirecolor = white
						-- Poner el planeta en la orbita
						planet.pos.controller = Path_Constraint() 
						planet.pos.controller.path = orbit 
						-- Rotar 
						orbit.rotation.z_rotation = random 0.0 360.0 
					) 
			)
		on but_createPlanetsElip pressed do 
			( 
				for i = 1 to spn_numPlanets.value do
					( 
						--GRUPO DE PLANETAS CERCANOS AL SOL PEQUEÑOS
						
						planet = sphere() -- Create the planet 
						planet.radius = random 10.0 18.0 
						-- Color planetas aleatorios
						planet.wirecolor = color (random 0 255) (random 0 255) (random 0 255)
						orbit = ellipse()
						orbit.length = i * random 300 310
						orbit.width = i * random 200 210
						--Pintar color de la órbita para diferenciarla facilmente
						orbit.wirecolor = green
						planet.pos.controller = Path_Constraint() 
						planet.pos.controller.path = orbit 
						orbit.rotation.z_rotation = random 0.0 360.0
						
						--GRUPO DE PLANETAS LEJANOS AL SOL CON ANILLOS 
						
						esfera = sphere()
						esfera.wirecolor = color (random 0 255) (random 0 255) (random 0 255)
							nose = cylinder()
							nose.wirecolor = yellow
						esfera.radius = random 25.0 35.0
							nose.radius = random 40.0 45.0
							nose.height = 0.2 
						orbita = ellipse() 
						orbita.length = i * random 1500 1515 
						orbita.width = i * random 1100 1115
						orbita.wirecolor = white
						esfera.pos.controller = Path_Constraint() 
							nose.pos.controller = Path_Constraint() 
						esfera.pos.controller.path = orbita 
							nose.pos.controller.path = orbita 
						orbita.rotation.z_rotation = random 0.0 360.0 
					) 
			)
			local pPlanet
			local pOrbit
			local pSat
			local pPos
		on pbt_pickPlanet picked aPlanet do
		(
			pPlanet = aPlanet
			-- Elegir planeta
			spn_planetRadius.value = aPlanet.radius
			pOrbit = aPlanet.pos.controller.path
			spn_orbitRadius.value = pOrbit.radius
		)
		
		on spn_planetRadius changed value do 
			( 
				--Cambiar radio
				pPlanet.radius = spn_planetRadius.value
			)
			
		on spn_orbitRadius changed value do 
			( 
				--Cambiar radio de la orbita
				pOrbit.radius = spn_orbitRadius.value 
			)
			
		on pbt_destruir picked aPlanet do
		(
			--Destruir planeta
			delete aPlanet
		)
					
		--SATELITES
		  on theColor changed new_col do 
			  selection.wirecolor = new_col
		
		on pbt_pickPlanetSat picked aPlanet do
		(
			--Crear satelite que orbite al planeta seleccionado
			pPlanet = aPlanet
			pOrbit = aPlanet.pos.controller.path

			pPos = aPlanet.position
			crearSatelite(pOrbit)
		)
		on disparo pressed do
	(
				meditMaterials[1].Diffuse = yellow
				meditMaterials[1].ambient = yellow
			
			if isvalidnode $fuente do(
			particulas = #()
			segundos=60
			for j=1 to segundos 
			do(
				numero=35
				for i = 1 to numero
				do(
						
						radio=6 * random(1-0.45) (1+0.45)
						
						posx=$fuente.pos.x
						posy=$fuente.pos.y
						posz=$fuente.pos.z
						
					bala = Sphere radius:radio segs:6 pos:[posx,posy,posz]
					bala.dir = $fuente.dir
					bala.wirecolor = yellow
						
						
					rotate bala (angleaxis 453 [random -1 1,random -1 1,random -1 1])
					toolMode.coordsys #local
						
					append particulas bala 
						
					alcance = 3000 * random 0.7 1.3
					angulo = random 40 60
						
					dos_angulo = angulo * 2 as float
					alcax = cos(random 0 360)
					alcay = cos(random 0 360)
					v = ((alcance * 1 + posz*1))^0.5 as float
					vx = v* alcax as float
					vy = v* alcay as float
					vz = v * sin(angulo) as float
					
					frames = segundos
						
					fotograma_inicial = (sliderTime as integer)/ticksperframe + j-1
					fotograma_final = ceil(fotograma_inicial + frames as float)
					
					pos_inicial = bala.pos
					x_inicial =bala.pos.x
					y_inicial =bala.pos.y
					z_inicial =bala.pos.z
					
					t0 = 0
					
					
					animate on for fotograma = fotograma_inicial to fotograma_final - 1 by 1 do
						at time fotograma
						(
							x= x_inicial + vx * t0 as float
							y= y_inicial + vy * t0 as float
							z= z_inicial + (vz * t0) - (0.5 * 1 * (t0 ^ 2))  as float
							
							bala.pos = [x, y, z]
							t0 = t0 +1
						)
				
				)
			)
			--append todasparticulas particulas
		)
	)
	) 
	
		createDialog ssRoll 225 425
	
	-- FUNCION SATELITES
fn crearSatelite  orb =
(
	planet = sphere() -- Create the planet 
	planet.radius = random 2.0 8.0 
	orbit = circle radius:40 
	orbit.pos = orb.pos
	
	--Definir la orbita del satelite en torno al planeta
	--Juntar la orbita del satelite a la orbita del planeta
	planet.pos.controller = Path_Constraint() 
	planet.pos.controller.path = orbit 
		orbit.pos.controller = Path_Constraint ()
		orbit.pos.controller.path = orb
)

		