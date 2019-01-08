package theCreator;

import java.io.BufferedWriter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.CardStrings;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;

import theCreator.cards.*;

@SpireInitializer
public class TheCreatorMod implements PostInitializeSubscriber, EditCardsSubscriber,EditStringsSubscriber {
	
	public static final Logger logger = LogManager.getLogger(TheCreatorMod.class.getName());
	private static final String LOG_FILE = "creator.log";
	private static final String MODNAME = "The Creator Mod";
	private static final String AUTHOR = "XR";
	private static final String DESCRIPTION  = "v0.1.0";
	
	public static final String ASSET_FOLDER = "img/";
	public static final String LOCALIZATION_FOLDER = "localization";
	private static final Color MOD_GRAY = CardHelper.getColor(46.0f, 139.0f, 87.0f);
	

	
	public TheCreatorMod(){
		logger.info("====Start Subscribing====");
		BaseMod.subscribe(this);
		logger.info("====Finish Subscribing====");
	
	}
	public static void initialize(){
		logger.info("====INITIALIZATION====");
		logger.info("====The CREATOR MOD====");
		new TheCreatorMod();
	}

	

	
	
	

	
	
	@Override
	public void receiveEditCards() {
		// New Colorless Cards
		BaseMod.addCard(new LuckyHand());
		BaseMod.addCard(new Random_Search());
		BaseMod.addCard(new MagicHat());
	}

	@Override
	public void receiveEditStrings() {
		logger.info("----start load strings----");
		String jsonstr = Gdx.files.internal("localization/ColorlessCards.json").
			readString(String.valueOf(StandardCharsets.UTF_8));
		BaseMod.loadCustomStrings(CardStrings.class, jsonstr);
		logger.info("----finish load strings----");
		
	}
	@Override
	public void receivePostInitialize() {
		// TODO Auto-generated method stub
		
	}
	
}
