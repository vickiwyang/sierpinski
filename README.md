# sierpinski [COS 126]

**Transform2D.java** is a library of static methods that performs geometric transforms (scaling, translation, and rotation) on polygons.

**Art.java** uses this library to create *De Stijl*-inspired line art. The program draws *n*-levels of rectangles that are randomly "split" horizontally or vertically, with each level scaling down to 50-90 percent of the previous level's size. Rectangle size, line thickness, and angle of split vary randomly across levels, so that a different graphic is produced each time the program is run.

For example, here are three variation of `Art 1` through `Art 9`:

![alt text](https://github.com/vickiwyang/sierpinski/blob/main/squares_h.png)

**Sierpinski.java** recursively plots a [Sierpinski triangle](https://en.wikipedia.org/wiki/Sierpi%C5%84ski_triangle) of order *n*.
