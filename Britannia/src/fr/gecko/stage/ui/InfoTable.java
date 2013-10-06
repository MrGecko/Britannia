package fr.gecko.stage.ui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.esotericsoftware.tablelayout.Cell;

import fr.gecko.britannia.Britannia;
import fr.gecko.camera.CameraController;
import fr.gecko.resource.BritanniaAssetManager;

public class InfoTable extends Table {
	
	private CameraController cameraCtrl;
	
	
	private Image cellImage;
	private Label cellName;
	
	public InfoTable(CameraController camCtrl) {
		super();
		setName("infoTable");
		cameraCtrl = camCtrl;
		
		BritanniaAssetManager assetManager = Britannia.getAssetManager();
		
		NinePatchDrawable tableBackground = new NinePatchDrawable(assetManager.getUiAtlas().createPatch("default-pane"));
		setWidth(300);
		setHeight(cameraCtrl.getHeight());
		setPosition(cameraCtrl.getWidth() - getWidth(), 0);
		
		cellName = new Label(" ", assetManager.getUiSkin());
		cellName.setName("cellName");
		cellImage = new Image();
		cellImage.setName("cellImage");

		setBackground(tableBackground);
		
		pad(4f);
		top();
		add(cellImage).expandX();
		row();
		add(cellName).expandX().fillX();
		
		//debug();
	}
	
	public void setCellImage(TextureRegion region) {
		
		@SuppressWarnings("unchecked")
		Cell<Image> c = getCell(cellImage);
		
		cellImage = new Image(region);
		c.setWidget(cellImage);

	}

	public void setCellName(String name) {
		cellName.setText(" " + name);
	}

}
