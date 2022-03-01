package model;

public class App {

	private String name, category, rating, reviews, size, installs, type, price, content_rating, genres, last_update, current_ver, android_ver;

	
	public App() {
		
	}
	
	public App(String name, String category, String rating, String reviews, String size, String installs, String type,
			String price, String content_rating, String genres, String last_update, String current_ver,
			String android_ver) {
		super();
		this.name = name;
		this.category = category;
		this.rating = rating;
		this.reviews = reviews;
		this.size = size;
		this.installs = installs;
		this.type = type;
		this.price = price;
		this.content_rating = content_rating;
		this.genres = genres;
		this.last_update = last_update;
		this.current_ver = current_ver;
		this.android_ver = android_ver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getInstalls() {
		return installs;
	}

	public void setInstalls(String installs) {
		this.installs = installs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContent_rating() {
		return content_rating;
	}

	public void setContent_rating(String content_rating) {
		this.content_rating = content_rating;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}

	public String getCurrent_ver() {
		return current_ver;
	}

	public void setCurrent_ver(String current_ver) {
		this.current_ver = current_ver;
	}

	public String getAndroid_ver() {
		return android_ver;
	}

	public void setAndroid_ver(String android_ver) {
		this.android_ver = android_ver;
	}

	@Override
	public String toString() {
		return "App [name=" + name + ", category=" + category + ", rating=" + rating + ", reviews=" + reviews
				+ ", size=" + size + ", installs=" + installs + ", type=" + type + ", price=" + price
				+ ", content_rating=" + content_rating + ", genres=" + genres + ", last_update=" + last_update
				+ ", current_ver=" + current_ver + ", android_ver=" + android_ver + "]";
	}
	
	
	
		
	
}
