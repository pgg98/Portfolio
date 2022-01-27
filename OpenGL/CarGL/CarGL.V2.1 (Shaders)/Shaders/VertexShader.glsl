attribute vec2 a_TextureCoord;
varying vec2 v_TextureCoord;
varying vec4 v_Luz;


attribute vec4 a_Position;
attribute vec3 a_Normal;

uniform mat4 u_ProjectionMatrix;
uniform mat4 u_MVMatrix;
uniform mat4 u_VMatrix;
uniform vec4 u_Color;

uniform int  u_Luz0;
uniform int  u_Luz1;
uniform int  u_Luz2;


uniform vec4 u_Position_Luz0;

uniform vec4 u_Position_Luz1;

uniform vec4 u_Position_Luz2;


uniform float u_Intensidad0;



uniform int u_selection_enabled;

varying vec4 v_Color;

void main(){
    if(u_selection_enabled == 0){
        vec3 P = vec3(u_MVMatrix * a_Position);
        vec3 N = vec3(u_MVMatrix * vec4(a_Normal, 0.0));

        vec3 viewVec = normalize(vec3(-P));

        float ambient = 0.15;


        /////////// LUZ 0 ////////////////

        vec4  LightPos0 = u_VMatrix * u_Position_Luz0;

        float d0 = length(LightPos0.xyz - P);
        vec3  L0 = normalize(LightPos0.xyz - P);
        float diffuse0 = 0.0;
        float specular0 = 0.0;
        if (u_Luz0 > 0) {
            diffuse0 = max(dot(N, L0), 0.0);
            // Cálculo de la atenuación
            float attenuation0 = 80.0/(0.25+(0.01*d0)+(0.003*d0*d0));
            diffuse0 = diffuse0*attenuation0*u_Intensidad0;

            // calculo de la especular.
            vec3 lightVec0 = L0;
            vec3 reflectVec0 = reflect(-lightVec0, N);
            specular0 = clamp(dot(reflectVec0, viewVec),0.0, 1.0);
            specular0 = pow(specular0, 5.0);
            specular0 = specular0*u_Intensidad0;
        }

        ////////// LUZ 1 /////////////////
        vec4  LightPos1 = u_VMatrix * u_Position_Luz1;
        float d1 = length(LightPos1.xyz - P);
        vec3  L1 = normalize(LightPos1.xyz - P);
        float diffuse1 = 0.0;
        if (u_Luz1 > 0) {
            diffuse1 = max(dot(N, L1), 0.0);
            // Cálculo de la atenuación
            float attenuation1 = 80.0/(0.25+(0.01*d1)+(0.003*d1*d1));
            diffuse1 = diffuse1*attenuation1;
        }

        ////////// LUZ 2 /////////////////
        vec4  LightPos2 = u_VMatrix * u_Position_Luz2;
        float d2 = length(LightPos2.xyz - P);
        vec3  L2 = normalize(LightPos2.xyz - P);
        float diffuse2 = 0.0;
        if (u_Luz2 > 0) {
            diffuse2 = max(dot(N, L2), 0.0);
            // Cálculo de la atenuación
            float attenuation2 = 80.0/(0.25+(0.01*d2)+(0.003*d2*d2));
            diffuse2 = diffuse2*attenuation2;
        }

        // PARA LAS TEXTURAS.
        v_Luz = vec4(ambient + diffuse0 + diffuse1 + diffuse2 + specular0);


        v_Color = u_Color * v_Luz;
        v_TextureCoord = a_TextureCoord;
        gl_Position = u_ProjectionMatrix * vec4(P, 1.0);
    }
    else{
        vec3 P = vec3(u_MVMatrix * a_Position);
        v_Color = vec4(u_Color.x, u_Color.x, u_Color.x, 0);
        v_TextureCoord = a_TextureCoord;
        gl_Position = u_ProjectionMatrix * vec4(P, 1.0);
    }
}
