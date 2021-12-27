#version 330 core

uniform sampler2D image;
uniform vec4 spriteColor;

in vec2 TexCoords;

out vec4 color;

void main() {

    color = spriteColor * texture(image, TexCoords);

}