bldr = new groovy.swing.SwingBuilder()

frame = bldr.frame(
title: 'Swing',
size: [50, 100],
layout: new java.awt.FlowLayout(),
defaultCloseOperation:javax.swing.WindowConstants.EXIT_ON_CLOSE
) {
  lbl = label(text: 'test')
  btn = button(text: 'Click me', actionPerformed: {
		 btn.text = 'Clicked'
		 lbl.text = "Groovy!"
	       })
}

frame.show()