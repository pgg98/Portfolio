Rollout fin "Crear CTRL Lider..." --- Creado por MAVDigital ---
(
	
Group "PROYECTO L.E.M."
(	
	
button fin "Finalisar"
on fin pressed do
(
mi_fin = Rectangle name:"La_Base" thickness:0.5 sides:3  render_displayRenderMesh:on 
mi_fin.length = 10
mi_fin.width = 10

--- mi_fin.thickness = 0.5
--- mi_fin.sides = 3
--- mi_fin.cornerRadius = 0

mi_fin.renderable = off
mi_fin.width.controller = bezier_float()
mi_fin.length.controller = bezier_float()
	
mi_fin1 = circle name:"CTRL_Lider" radius:2 thickness:0.5 sides:3  render_displayRenderMesh:on
	
--- mi_fin1.radius = 2
--- mi_fin1.thickness = 0.5
--- mi_fin1.sides = 3
	
mi_fin1.parent = mi_fin	

mi_fin1.pos.controller.X_Position.controller = float_limit ()
mi_fin1.pos.controller.X_Position.controller.upper_limit = 5
mi_fin1.pos.controller.X_Position.controller.lower_limit = -5
	
mi_fin1.pos.controller.y_Position.controller = float_limit ()
mi_fin1.pos.controller.y_Position.controller.upper_limit = 5
mi_fin1.pos.controller.y_Position.controller.lower_limit = -5
	
mi_fin1.pos.controller.z_Position.controller = float_limit ()
mi_fin1.pos.controller.z_Position.controller.upper_limit = 0
mi_fin1.pos.controller.z_Position.controller.lower_limit = -0

mi_fin1.pos.controller.X_Position.controller.upper_limit.controller = Float_Expression ()
mi_fin1.pos.controller.X_Position.controller.upper_limit.controller.AddScalarTarget "Ancho" mi_fin.width.controller
mi_fin1.pos.controller.X_Position.controller.upper_limit.controller.setExpression "Ancho/2"


mi_fin1.pos.controller.X_Position.controller.lower_limit.controller = Float_Expression ()
mi_fin1.pos.controller.X_Position.controller.lower_limit.controller.AddScalarTarget "Ancho" mi_fin.width.controller
mi_fin1.pos.controller.X_Position.controller.lower_limit.controller.setExpression "-Ancho/2"


mi_fin1.pos.controller.y_Position.controller.upper_limit.controller = Float_Expression ()
mi_fin1.pos.controller.y_Position.controller.upper_limit.controller.AddScalarTarget "Altura" mi_fin.length.controller
mi_fin1.pos.controller.y_Position.controller.upper_limit.controller.setExpression "Altura/2"

mi_fin1.pos.controller.y_Position.controller.lower_limit.controller = Float_Expression ()
mi_fin1.pos.controller.y_Position.controller.lower_limit.controller.AddScalarTarget "Altura" mi_fin.length.controller
mi_fin1.pos.controller.y_Position.controller.lower_limit.controller.setExpression "-Altura/2"

$CTRL_Lider.name = "Control"
$La_Base.name = "Base"

mi_Texto = Text name:"TextoCL" thickness:0.1 sides:3  render_displayRenderMesh:on
mi_Texto.size = 2
mi_Texto.Text = "CTRL LIDER"
move mi_Texto [0.0,6.69973,0.0]
mi_Texto.parent = mi_fin
mi_Texto.wirecolor = color 8 8 136

--- mi_Texto.thickness = 0.1
--- mi_Texto.sides = 3

mi_fin.wirecolor = color 0 0 0
mi_fin1.wirecolor = color 134 6 6

--- paramWire.connect $Control.pos.controller.X_Position.controller[#Limited_Controller__Bezier_Float] $CTRL_Flexible.rotation.controller[#Y_Rotation] "Limited_Controller__Bezier_Float"
--- paramWire.connect $Control.pos.controller.Y_Position.controller[#Limited_Controller__Bezier_Float] $CTRL_Flexible.rotation.controller[#X_Rotation] "Limited_Controller__Bezier_Float"

)
)

label mavd "MAVDigital 2011"
label mavd1 "Magia, Arte, Visualización Digital"
)
createdialog fin 170 100