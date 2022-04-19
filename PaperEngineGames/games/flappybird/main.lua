function init()

end

posX = 0
posY = 0

function render()
    paper:clear()
    paper:clearColor(0,0,0,0)
    paper:drawSprite("bird",posX,posY,5,5)
end

function update(delta)
    if input:isKeyPressed(keycode.PAPER_KEY_SPACE) == true then
        posY=posY+100*delta
    end
    camera:setFocusPosition(posX,posY)
    posX=posX+100*delta
end