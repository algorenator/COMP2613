package examples.collections;

/**
 * An item with a description and a part number.
 */
public class Item implements Comparable<Item> {
		
		private String description;
		private int partNumber;
		private int price;
		private float discount;
		
		/**
		 * Constructs an item.
		 * 
		 * @param aDescription
		 *            the item's description
		 * @param aPartNumber
		 *            the item's part number
		 */
		public Item(String description, int partNumber) {
			this.description = description;
			this.partNumber = Integer.valueOf(partNumber);
		}

		public Item(String description, String partNumberString, int price, float discount) {
			this.description = description;
			this.partNumber = Integer.valueOf(partNumberString);
		}

		/**
		 * Gets the description of this item.
		 * 
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @return the partNumber
		 */
		public int getPartNumber() {
			return partNumber;
		}

		/**
		 * @param partNumber the partNumber to set
		 */
		public void setPartNumber(int partNumber) {
			this.partNumber = partNumber;
		}

		/**
		 * @return the price
		 */
		public int getPrice() {
			return price;
		}

		/**
		 * @param price the price to set
		 */
		public void setPrice(int price) {
			this.price = price;
		}

		/**
		 * @return the discount
		 */
		public float getDiscount() {
			return discount;
		}

		/**
		 * @param discount the discount to set
		 */
		public void setDiscount(float discount) {
			this.discount = discount;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return "[descripion=" + description + ", partNumber=" + partNumber + "]";
		}

		@Override
		public boolean equals(Object other) {
			if (getClass() == other.getClass()) {
				Item otherItem = (Item) other;
				return description.equals(otherItem.description) && partNumber == otherItem.partNumber;
			} else
				return false;
		}

		@Override
		public int hashCode() {
			return 13 * description.hashCode() + 17 * partNumber;
		}

		public int compareTo(Item other) {
			Item otherItem = (Item) other;
			return partNumber - otherItem.partNumber;
		}

	}
