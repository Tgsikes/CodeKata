package org.kata.vending.factory;

import java.util.ArrayList;
import java.util.List;

import org.kata.vending.busObjs.Coin;
import org.kata.vending.busObjs.Tolerance;

public class CoinFactory {
	private static CoinFactory singleton = null;
	private List<CoinMetaData> coinTypes;;

	public List<CoinMetaData> getCoinTypes() {
		if (coinTypes == null)
			coinTypes = new ArrayList<CoinMetaData>();
		return coinTypes;
	}

	public void setCoinTypes(List<CoinMetaData> coinTypes) {
		this.coinTypes = coinTypes;
	}

	public Coin create(double weight, double diameter, double thickness) {
		Coin rtn = null;
		for (CoinMetaData coinMetaData : coinTypes) {
			if (coinMetaData.isMatch(weight, diameter, thickness)) {
				rtn = new Coin(coinMetaData.getValue());
				break;
			}
		}
		if (null == rtn)
			throw new NoSuchCoinException();
		else
			return rtn;
	}

	public Coin create(VendingDeposit userDeposit) {
		Coin rtn = null;
		
		for (CoinMetaData coinMetaData : coinTypes) {
			if (coinMetaData.equals(userDeposit)) {
				rtn = new Coin(coinMetaData.getValue());
				break;
			}
		}
		if (null == rtn)
			throw new NoSuchCoinException();
		else
			return rtn;
	}
	
	
}
