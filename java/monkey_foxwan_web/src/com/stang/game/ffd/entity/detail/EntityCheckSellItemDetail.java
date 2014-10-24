package com.stang.game.ffd.entity.detail;

public class EntityCheckSellItemDetail {
		private int SellmasttypeId;//主类型
		private int SellitemId;//道具id
		private int SellbuyNum;//道具数量
		private int Sellprice;//购买价格
		
		public int getSellmasttypeId() {
			return SellmasttypeId;
		}
		public void setSellmasttypeId(int sellmasttypeId) {
			SellmasttypeId = sellmasttypeId;
		}
		public int getSellitemId() {
			return SellitemId;
		}
		public void setSellitemId(int sellitemId) {
			SellitemId = sellitemId;
		}
		public int getSellbuyNum() {
			return SellbuyNum;
		}
		public void setSellbuyNum(int sellbuyNum) {
			SellbuyNum = sellbuyNum;
		}
		public int getSellprice() {
			return Sellprice;
		}
		public void setSellprice(int sellprice) {
			Sellprice = sellprice;
		}
}
