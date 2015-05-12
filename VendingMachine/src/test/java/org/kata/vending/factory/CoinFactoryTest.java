package org.kata.vending.factory;

import static org.junit.Assert.assertEquals;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kata.vending.busObjs.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:VendingMachine.xml")
public class CoinFactoryTest {
	@Autowired
	private CoinFactory factory = null;

	public CoinFactory getFactory() {
		return factory;
	}

	public void setFactory(CoinFactory factory) {
		this.factory = factory;
	}

	@Test
	public void factoryReturnsCoinWhenPassedSpecification() {
		Coin coin = factory.create(2.5, 19.05, 1.52);
		assertEquals(.01, coin.getValue(),0);
		coin = factory.create(5, 21.21, 1.95);
		assertEquals(.05, coin.getValue(),0);
		coin = factory.create(2.268, 17.91, 1.35);
		assertEquals(.1, coin.getValue(),0);
		coin = factory.create(5.67, 24.26, 1.75);
		assertEquals(.25,coin.getValue(),0);
		coin = factory.create(11.34, 30.61, 2.15);
		assertEquals(.5,coin.getValue(),0);
		coin = factory.create(8.1, 26.49, 2);
		assertEquals(1,coin.getValue(),0);
	}
	
	@Test(expected=NoSuchCoinException.class)
	public void factoryThrowsExceptionWhenNoMatch()
	{
		Coin coin = factory.create(2.5, 19.05, 1.52);
		coin = factory.create(8.1, 26, 2);
		assertEquals(1,coin.getValue(),0);
	}
	@Test
	public void factoryReturnsCurrencyWhenPassedInputObject()
	{
		assertEquals(.01,factory.create(new CoinageInput(2.5, 19.05, 1.52)).getValue(),0);
		
	}
	@Test(expected=UnsupportedOperationException.class)
	public void factoryThrowsUnsupportedExceptionForPaperMoney(){
		assertEquals(1, factory.create(new PaperInput(new BufferedImage(1,2,BufferedImage.TYPE_INT_RGB))).getValue(),0);
	}
	
}
