varying vec4 v_Color;

// PARA LAS TEXTURAS.
varying vec2 v_TextureCoord;
varying vec4 v_Luz;
uniform sampler2D u_Sampler;
uniform int activada;


void main(){
        if(activada == 0){
    		gl_FragColor = v_Color;
        }
        else{
            gl_FragColor = texture2D(u_Sampler, v_TextureCoord)*v_Luz;
        }
}
