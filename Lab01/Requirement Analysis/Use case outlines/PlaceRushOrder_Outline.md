# Use case outline
## Use case "Place rush order"
### Basic flow of event
| No | Doer | Action |
| :----- | :---------- | :-------------- |
| 1 | Customer | request place rush order |
| 2 | Software | check if is available |
| 3 | Software | display + ask customer update info |
| 4 | Customer | update rush order info |
| 5 | Software | check valid input |
| 6 | Software | check items available + combine items can be rushed + calculate shipping fee + schedule time to ship |
| 7 | Software | continue place order flow |
### Alternative flow of event
| Location | Condition | Action | Resume location |
| :----- | :---------- | :-------------- | :----------------- |
| Step 2 | rush order isn't supported | ask customer update order | end use case |
| Step 5 | info isnot valid | ask customer update info | back to step 4 |
| Step 6 | items not available | ask customer update info | back to step 4 |

