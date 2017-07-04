package br.edu.utfpr.md.umacolher.object;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.opengl.CCBitmapFontAtlas;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor3B;

import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenHeight;
import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenWidth;

/**
 * Created by victor on 02/07/17.
 */

public class Score extends CCLayer {

    private int score;
    private CCLabel texto;

    public Score(){
        this.score = 0;
        this.texto = CCLabel.makeLabel(Integer.toString(this.score), "8bit.ttf", 80 );
        this.texto.setColor(ccColor3B.ccc3(252, 70, 44));
        this.setPosition(1760, 1000);
        this.addChild(this.texto);
    }

    public void increase() {
        score++;
        this.texto.setString(String.valueOf(this.score));
    }

    public int getPontos(){
        return score;
    }

}
