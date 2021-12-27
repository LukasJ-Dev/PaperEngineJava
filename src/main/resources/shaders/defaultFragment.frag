#version 330 core

uniform float uTime;
uniform sampler2D TEX_SAMPLER;
uniform vec2 uMouse;

in vec4 fColor;
in vec2 fTexCoords;

out vec4 color;

void main() {

    vec4 t = (texture(TEX_SAMPLER, fTexCoords));


    color = t;

    /*
    vec2 res = vec2(1800, 900);
    vec2 position = 4.*( gl_FragCoord.xy / res.xy);

    for(int n=1; n<6; n++){
        float i = float(n);
        //y = 0.5 / 1
        position += vec2(.5/i*sin(i*i*position.y+uTime)+1.8, .4/i*sin(i*i*position.x+uTime)+1.6);

    }

    float colorr = .5*sin(position.x ) + .5;
    float colorg = .9*sin(position.y) + .5;
    float colorb = sin(position.x+position.y);

    vec4 t = (texture(TEX_SAMPLER, (vec2(colorr, colorg) * fTexCoords)));


    color = t;*/
}

/*

    vec2 res = vec2(1800, 900);
    vec2 position = 4.*( gl_FragCoord.xy / res.xy);


    for(int n=1; n<100; n++){
        float i = float(n);

        position += vec2(.7/i*sin(i*position.y*i+uTime+.3*i)+.8, .4/i*sin(i*position.x*i+uTime+.3*i)+1.6);

    }



    float colorr = .5*sin(position.x ) + .5;
    float colorg = .9*sin(position.y) + .5;
    float colorb = sin(position.x+position.y);

    vec4 t = (texture(TEX_SAMPLER, fTexCoords)) * -1.0f * sin(uTime);


    color = vec4( vec3( colorr, colorg, colorb ), 1.0 );
*/