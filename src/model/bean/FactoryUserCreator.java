package model.bean;

import util.UserType;


public class FactoryUserCreator {

	public AbstractFactoryUser getFactory(UserType type){
		switch (type) {
		case ADMIN:
			return new AdminFactory();
		case USER:
			return new UserFactory();
		default:
			return null;
		}
	}
	
	public static void main(String[] args) {
		FactoryUserCreator creator = new FactoryUserCreator();
		AbstractFactoryUser factoryUser = creator.getFactory(UserType.USER);
		User user = factoryUser.getUser();
		
		System.out.println("creato " + user.getClass());
	}
}
