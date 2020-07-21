[![](https://jitpack.io/v/EmmanuelGuther/GridToLinear.svg)](https://jitpack.io/#EmmanuelGuther/GridToLinear)

# GridToLinear
An android library that allows you to change a recyclerview from list mode to grid mode.

![](20200721_104412.gif)



If you want to be able to change the way of showing your recyclerview from list to grid mode, with very few lines of code it is possible. You will also have to have added a button in your toolbar and created a menu, in the example is everything.



Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.EmmanuelGuther:GridToLinear:1.0.0-rc'
	}



## How to use this?

You must initialize the library and pass it a few parameters:

    override fun onCreate(savedInstanceState: Bundle?) {
       ...
      GridToLinear().build(
                 this, 
                 recyclerView,
                 2, //Grids 
                 R.drawable.ic_grid_list_24dp, // Icon for grid mode
                 R.drawable.ic_list_white_24dp, // Icon for list mode
                 resources.getDimension(R.dimen.margin_normal).toInt(), //Dimension for margin in list mode ej: 8dp
                 resources.getDimension(R.dimen.margin_grid).toInt()  //Dimension for margin in grid mode ej: 2dp
        )
    }

And we have to notify the library when the user clicks the icon:

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
          return when (item.itemId) {
              R.id.list -> {
                  GridToLinear().change(item)
                  true
              }
              else -> super.onOptionsItemSelected(item)
          }
    }
    

And that's all:
Anyway, in this repository (in the app folder) you have an example in detail.

