package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Rectangle;

// LobbyScreen for the players, not the host
public class LobbyScreen extends Screen {
    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();

    float scaleWidth = (float)(Gdx.graphics.getWidth() * 0.4);
    float scaleHeight = (float)(scaleWidth * 0.3);
    float scaleLogo = (float)(scaleWidth * 0.8);
    float scaleExit = (float)(Gdx.graphics.getWidth() * 0.1);
    private Texture backgroundUpper;
    private Texture backgroundLower;
    private Texture exit;
    private Rectangle boundsExitField;
    private Texture logo;

    private BitmapFont gamePinCode;
    private BitmapFont playersJoinedText;
    private BitmapFont player1Text;
    private BitmapFont player2Text;
    private BitmapFont player3Text;
    private BitmapFont player4Text;

    private String player1  = "1";
    private String player2 = "2";
    private String player3 = "3";
    private String player4 = "4";

    private String lobbyCode;

    public LobbyScreen(GameScreenManager gsm, String lobbycode) {
        super(gsm);
        this.lobbyCode = lobbycode;
        backgroundUpper = new Texture("background.png");
        backgroundLower = new Texture("background2.png");
        exit = new Texture("cancelButton.png");
        boundsExitField = new Rectangle(
                (float)(width * 0.05),
                (float)(height * 0.08) - scaleExit,
                scaleExit, scaleExit);
        logo = new Texture("bottomsUpLogoNoText.png");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("myfont.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int)width*1/11;
        parameter.color = new Color(0x022444ff);
        gamePinCode = generator.generateFont(parameter);
        playersJoinedText = generator.generateFont(parameter);
        player1Text = generator.generateFont(parameter);
        player2Text = generator.generateFont(parameter);
        player3Text = generator.generateFont(parameter);
        player4Text = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            if (boundsExitField.contains(x, y)) {
                gsm.set(new MainMenuScreen(gsm));
                dispose();
            }
        }
    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(backgroundUpper, 0, 0, width, height);
        sb.draw(backgroundLower, 0, 0, width, (float)(height * 0.63));
        sb.draw(exit, (float)(width * 0.05), (float)(height * 0.92), scaleExit, scaleExit);
        sb.draw(logo, (float)(width * 0.3), (float)(height * 0.81), scaleWidth, scaleLogo);
        gamePinCode.draw(sb,
                "Game pin: \n" + lobbyCode,
                (float)(width * 0.28),
                (float)(height * 0.79));
        playersJoinedText.draw(sb,
                "Players joined:",
                (float)(width * 0.16),
                (float)(height * 0.6));
        player1Text.draw(sb, player1, (float)(width * 0.16), (float)(height * 0.45));
        player2Text.draw(sb, player2, (float)(width * 0.16), (float)(height * 0.35));
        player3Text.draw(sb, player3, (float)(width * 0.16), (float)(height * 0.25));
        player4Text.draw(sb, player4, (float)(width * 0.16), (float)(height * 0.15));
        sb.end();
    }

    @Override
    public void dispose() {
        backgroundUpper.dispose();
        backgroundLower.dispose();
        exit.dispose();
        logo.dispose();
    }
}
