# The Shoe Store

This project will consist of five screens. You do not have to create a shoe store, you can use any other item (e.g., a book store), as long as you create the following screens:

1. Login screen - This screen will be comprised of "Email" and "Password" fields and labels, as well as "Create" and "Login" buttons. Redirects to the Welcome (onboarding) screen.
2. Welcome (onboarding) screen - This screen will be comprised of two TextViews w/ text of choice and a "Go to Instructions" button. Redirects to the Instructions (onboarding) screen.
3. Instructions (onboarding) screen - This screen will be comprised of two TextViews w/ text of choice and a "Go to Shoe List" button. Redirects to the Shoe Listing screen.
4. Shoe Listing screen - This screen will be comprised of a ScrollView w/ a LinearLayout within the ScrollView and will contain the list of shoes that have been added to the inventory. Additionally, there will be a FloatingActionButton that will redirect to the Shoe Detail screen (i.e., "Go to Shoe Detail") as well as a "Logout" menu (button) (within a navigation drawer) that redirects to the Login screen.
5. Shoe Detail screen (for adding a new shoe) - This screen will be comprised of a TextView label and EditView for the "Shoe Name", "Company", "Shoe Size" and "Description". Additionally, there will be a "Save" button that redirects to the Shoe List screen and adds a new shoe to the Shoe ViewModel. Also, there will be a "Cancel" button that redirects to the Shoe List screen.

## Getting Started

### Steps

1. Open the [starter project](https://github.com/udacity/nd940-android-kotlin-course1-starter) from the GitHub repo in Android Studio
<br></br>
2. Add the navigation libraries to the app `build.gradle` file
   - Done
<br></br>
3. Add the safe-arg plugin to the main and app `build.gradle` file
   - Done
<br></br>
4. Set `DataBindingUtil` in `build.gradle`
   - Done
<br></br>
5. Use `DataBindingUtil` to inflate every layout
<br></br>
6. Create a new navigation (graph) XML file
   - Done
<br></br>
7. Create a new Login screen (destination) that includes:

    * Include "Email" and "Password" labels
    * Include "Email" and "Password" fields
    * Create buttons for creating a new login (i.e., "Create Account") and logging in with an existing account (i.e., "Login")
    * Clicking either button should navigate to the Welcome screen

    - Done
<br></br>
8. Create a new Welcome (onboarding) screen (destination) that includes:

    * A new layout
    * At least 2 TextViews and use any text you would like
    * A navigation button with actions to navigate to the Instructions (onboarding) screen (i.e., "Go to Instructions")

    - Done
<br></br>
9. Create a new Instructions (onboarding) screen (destination) that includes:

    * A new layout
    * At least 2 TextViews with appropriate information
    * A navigation button with actions to navigate to the Shoe List screen (i.e., "Go to Shoe List")

    - Done
<br></br>
10. Create a class that extends `ViewModel`

    * Use a `LiveData` field that returns the list of shoes
    
    - Done
<br></br>
11. Create a new Shoe List screen (destination) that includes:

    * A new layout
    * A `ScrollView`
    * A `LinearLayout` inside the `ScrollView` for shoe items
    * A `FloatingActionButton` with an action to navigate to the Shoe Detail screen (i.e., "Go to Shoe Detail")
    
    - Done
<br></br>
12. In `MainActivity`, setup the nav controller with the toolbar and an `AppBarConfiguration`

    - Done
<br></br>
13. In the Shoe List screen, add a Logout menu (button). This Logout menu (button) will appear only on the Shoe List screen and will return the user to the Login screen

    - Done
<br></br>
15. Create a new Shoe Detail screen (destination) that includes:

    * A new layout
    * A `TextView` label and `EditView` for the "Shoe Name", "Company", "Shoe Size" and "Description"
    * A "Cancel" button with an action to navigate back to the Shoe List screen
    * A "Save" button with an action to navigate back to the Shoe List screen and add a new shoe to the Shoe ViewModel

    - Done
<br></br>
16. Make sure you cannot go back to the onboarding screens in the Shoe List screen:

    * Use an Activity level `ViewModel` to hold a list of shoes (Shoes) (use by `activityViewModels`)
    * Observe the shoes variable from the `ViewModel`
    * Add a new layout item into the ScrollView for each shoe

    - Done