package controller;

import java.util.HashMap;
import java.util.Map;

import controller.book.AddBookController;
import controller.book.DeleteBookController;
import controller.book.GetBookListController;
import controller.book.SearchBookController;
import controller.homepage.HomepageController;
import controller.rent.AddRentController;
import controller.rent.GetAllRentalController;
import controller.rent.ReturnBookController;
import controller.rent.UserRentalController;
import controller.user.GetUserInfoController;
import controller.user.GetUserListController;
import controller.user.InsertUserController;
import controller.user.LoginController;
import controller.user.LogoutController;
import controller.user.PasswordController;
import controller.user.UserController;
import controller.user.UserDeleteController;
import controller.user.UserUpdateController;

public class HandlerMapping {

		private Map<String, Controller> mappings;
		public HandlerMapping() {
			mappings = new HashMap<String, Controller>();
			mappings.put("/homepage.do", new HomepageController());
			mappings.put("/insertUser.do", new InsertUserController());
			mappings.put("/login.do", new LoginController());
			mappings.put("/logout.do", new LogoutController());
			mappings.put("/getBookList.do", new GetBookListController());
			mappings.put("/addBook.do", new AddBookController());
			mappings.put("/deleteBook.do", new DeleteBookController());
			mappings.put("/searchBook.do", new SearchBookController());
			mappings.put("/addRent.do", new AddRentController());
			mappings.put("/getAllRentalList.do", new GetAllRentalController());
			mappings.put("/returnBook.do", new ReturnBookController());
			mappings.put("/returnBookList.do", new UserRentalController());
			mappings.put("/searchId.do", new UserController());
			mappings.put("/searchPassword.do", new PasswordController());
			mappings.put("/userInfo.do", new GetUserInfoController());
			mappings.put("/userUpdate.do", new UserUpdateController());
			mappings.put("/userList.do", new GetUserListController());
			mappings.put("/userDelete.do", new UserDeleteController());
			
		}
		public Controller getController(String path) {
			return mappings.get(path);
		}
		
}
