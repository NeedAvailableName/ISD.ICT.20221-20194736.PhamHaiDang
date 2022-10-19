# Use case outline
## Use case "Place order"
### Steps for placing order
1. order placement
2. order payment
3. order approval
4. delivery
5. post order support
### Basic flow of event
| No | Doer | Action |
| :----- | :---------- | :-------------- |
| 1 | Customer | view cart and request place order |
| 2 | Software | check if number is available |
| 3 | Software | ask customer to update info |
| 4 | Customer | update info + rush order (if needed) |
| 5 | Software | validate info + calculate payment and display to customer |
| 6 | Customer | accept |
| 7 | Software | move to order payment |
| 8 | Customer | enter info to pay order |
| 9 | Software | check balance |
| 10 | Software | save the pending order and send info to customer |
| 11 | Admin | accept the order |
| 12 | Software | check order again |
| 13 | Software | order successfully |
### Alternative flow of event
| Location | Condition | Action | Resume location |
| :----- | :---------- | :-------------- | :----------------- |
| Step 2 | order quantity isn't avalable | ask customer update order | back to step 1 |
| Step 5 | info isnnot valid or rush order isnot supported | ask customer update info | back to step 3 |
| Step 6 | customer doesnot accept order | display previous step | end use case |
| Step 9 | balance isnot enough | back to step 1| end use case |
| Step 11 | admin doesnot accept | notify user | end use case|
| Step 12 | order isn't avalable | ask customer update order | back to step 1 |
