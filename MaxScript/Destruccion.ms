if ((ssRoll != undefined) and (ssRoll.isdisplayed)) do 
	(destroyDialog ssRoll)
	
	fn explotar plan =
	actionMan.executeAction 0 "50026"  -- Tools: Maximize Viewport Toggle
Sphere radius:54.6155 pos:[2.46486,-13.0794,0] isSelected:on
toolMode.coordsys #view
move plan [0,0,21.6122]
PArray formation:0 numDistinctPoints:20 speed:10 Speed_Variation:0 Divergence_Angle:10 Birth_Rate:10 Total_Number:100 quantityMethod:0 viewPercent:10 Emitter_Start:0f Emitter_Stop:30f Display_Until:100f life:30f Life_Variation:0f subsampleEmitterTranslation:on subsampleCreationTime:on subsampleEmitterRotation:off size:1 Size_Variation:0 Growth_Time:10f Fade_Time:10f seed:12345 standardParticle:0 Metaparticle_Tension:1 Metaparticle_Tension_Variation:0 metaballAutoCoarsness:on metaballRenderCoarsness:0.5 metaballViewCoarsness:1 Fragment_Thickness:1 fragmentMethod:0 fragChunkMinimum:100 viewType:1 mappingType:0 Mapping_Time_Base:30f Mapping_Distance_Base:100 materialSource:0 Spin_Time:0f Spin_Time_Variation:0 Spin_Phase:0 Spin_Phase_Variation:0 spinAxisType:0 X_Spin_Vector:1 Y_Spin_Vector:0 Z_Spin_Vector:0 Spin_Axis_Variation:0 motionInfluence:100 motionMultiplier:1 motionVariation:0 Bubble_Amplitude:0 Bubble_Amplitude_Variation:0 Bubble_Period:100000f Bubble_Period_Variation:0 Bubble_Phase:0 Bubble_Phase_Variation:0 iconSize:91.8974 iconHidden:off fragEdgeMatID:2 fragBackMatID:3 Spawn_Generations:1 Spawn_Multiplier:1 Spawn_Affects:100 Use_Selected_Subobjects:0 Die__X_frames_after_collision:0f Die__X_frames_after_collision_variation:0 Interparticle_Collisions_On:0 Interparticle_Collision_Steps:2 Interparticle_Collision_Bounce:100 Interparticle_Collision_Bounce_Variation:0 pos:[-164.974,27.8563,0]	
	
	
	
	
	
		isSelected:on
		clearSelection()
		select plan
			plan.viewType = 2
			plan.Emitter_Start = 50f
			plan.Emitter_Stop = 100f
			sliderTime = 26f
			plan.Emitter_Start = 30f
			sliderTime = 0f
			plan.Size_Variation = 6.9
			plan.size = 121
			clearSelection()
			sliderTime = 0f
			select plan
			plan.Growth_Time = 12f
			plan.particleType = 2
			sliderTime = 20f
			plan.Fragment_Thickness = 8
clearSelection()
sliderTime = 40f
select plan
plan.fragmentMethod = 1
plan.fragChunkMinimum = 84
sliderTime = 36f
plan.fragChunkMinimum = 184
clearSelection()
sliderTime = 40f
sliderTime = 31f
select plan
plan.speed = 1
plan.Speed_Variation = 3.45
actionMan.executeAction 0 "59231"  -- Selection: Selection Lock Toggle
sliderTime = 53f
sliderTime = 56f
sliderTime = 30f
plan.Emitter_Start = 350f
plan.Emitter_Stop = 350f
plan.Emitter_Start = 50f
clearSelection()
sliderTime = 52f
select plan
plan.Speed_Variation = 10.45
sliderTime = 70f
plan.speed = 7
sliderTime = 0f
actionMan.executeAction 0 "59231"  -- Selection: Selection Lock Toggle
sliderTime = 51f
sliderTime -= 1
sliderTime -= 1
sliderTime += 1
sliderTime += 1
sliderTime -= 1
set animate on
sliderTime += 1
actionMan.executeAction 0 "40022"  -- Edit: Properties
select plan
actionMan.executeAction 0 "40022"  -- Edit: Properties
plan.visibility = 0
sliderTime = 51f
sliderTime = 51f
actionMan.executeAction 0 "40022"  -- Edit: Properties
plan.visibility = 0
sliderTime = 50f
sliderTime = 52f
select plan
plan.wirecolor = color 28 28 177
sliderTime = 49f
select plan
plan.wirecolor = color 8 8 136
sliderTime = 21f

rollout ssRoll "Solar System" 
	(
		spinner spn_SpheraRadius "Radio de la esfera" range:[1,1000,50]
		button createSphera "Crear esfera"
		button destroy "Destruccion"
		
		on createSphera pressed do 
			( 
				plan = sphere radius:spn_SpheraRadius.value
				
				explotar(plan)
			) 
			
		on destroy pressed do
		(
			
		)
	) 
		createDialog ssRoll 225 100