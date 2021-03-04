# Monefy Test Charter

This test charter provides all the information on this exploratory tests session related to Monefy app

Start Date: 02/03/2021
End Dte: 04/03/2021

Testers:
Thiago Fioravante de Matos

## Scope
App: Monefy Lite (Free version)
App version: 1.9.19
APK: https://www.apkmonk.com/download-app/com.monefy.app.lite/5_com.monefy.app.lite_2021-02-01.apk/
Devices/Platforms: 
- Pixel 3A/Android 11 
- Iphone 7/iOS 7
-(in a real world could be a list of more devices)

### Tests

1. Explore Expense button with positive values to dicover if negative balance are correct
2. Explore Expense button with zero or negative values to discover if user can't add them
3. Explore Expense button with all categories to discover if all categories are working as expected
4. Explore Income button with positive values to dicover if negative balance are correct
5. Explore Income button with zero or negative values to discover if user can't add them
6. Explore Income button with all categories to discover if all categories are working as expected
7. Explore all category buttons on grid with diferent values for income and expense to discover if category accept only positive numbers
8. Explore balance list with variations of income/expense and category/dates to discover if all records are grouped/ordered correctly
9. Explore deletion with income/expense to discover if after deletion the balance is correct
10. Explore date selection with income/expense in different dates to discover if landing page shows correct date label
10. Explore date selection with income/expense in different dates to discover if only the iten inside the date frame select is shown
11. Explore selecting account with different accounts to discover if landing page shows only records in that account
12. Explore searching with category name to discover if balance will show only records in that category
13. Explore searching with a note description to discover if balance will show only records with that description
14. Explore transfer with positive values to discover if balance is correct for each account
15. Explore transfer with high values to discover if is possible to transfer more money than the origin has.
16. Explore transfer with negative values to discover if app blocks the action
17. Explore transfer with same account to discover if app blocks the action
18. Explore rename category with valid name to discover if category name changes
19. Explore change category icon to discover if Monefy Pro ad is shown
20. Explore delete a category with records to discover if all records are deleted
21. Explore create a new account with valid name to discover if it will be listed in the account selector
22. Explore create a new account with different currency to discover if Monefy Pro ad is shown
23. Explore delete an account with records to discover if all recors will be deleted
24. Explore Currencies menu to discover if Monefy Pro ad is shown
25. Explore Settings with budget enabled to discover if a cap is used in balance calculation
26. Explore Settings with carry over enabled to discover if balance from previous period of time is added to balance
27. Explore Settings with future recurring records enabled to discover if this record option is enabled
28. Explore Settings with the Unlock Monefy Pro option to discover if Monefy Pro ad is shown
29. Explore Settings with Dark theme enabled to discover if Monefy Pro ad is shown
30. Explore Settings with different languages to discove if the app is shown with selected language
31. Explore Settings with different currencies to discover if all recors are shown in the selected currency
32. Explore Settings with different first day of the week to discover if the week start and end days are respected
33. Explore Settings with different first day of the month to discver if the month start and end dates are respected
34. Explore Settings with Passcode to discover id Monefy Pro ad is show
35. Explore Settings with review application to discover if store is open
36. Explore Settings with exporting to file to discover if a file is generated
37. Explore Settings with about Monefy to discover if an About popup is shown
38. Explore Settings with privacy policy to discover if user is redirected to privavy policy web page
39. Explore Settings with create backup to discover if a backup is saved in Monefy cloud
40. Explore Settings with restore backups to discover if a backups is restored corerctly
41. Explore Settings with clear date to discover if all records are deleted

## Prioritization

The focus of this exploratory tests should focus on adding/edditing/deleting records since this is the area where our users wil spent most of their times and it's the mais purpose of the app. If this area show any bug it will need to be raised immediately with the team so we can discuss it impact.
Secondly, focus on customization like currency and accounts, since this will be the one of the first things that we expect new users will do.
Then explore different views (dates) and search, And for last explore minor configurations settings like start date of the week, dark theme and etc.

### Bugs
