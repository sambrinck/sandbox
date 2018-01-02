package org.home.brinck

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class HelloWorld : Application() {

    override fun start(primaryStage: Stage) {
        val btn = Button()
        btn.text = "Say 'Hello World'"
        btn.onAction = EventHandler { println("Hello World!") }

        val root = StackPane()
        root.children.add(btn)

        val scene = Scene(root, 300.0, 250.0)

        primaryStage.title = "HELLO WORLD!"
        primaryStage.scene = scene
        primaryStage.show()
    }

    fun main(args: Array<String>) {
        Application.launch(*args)
    }
}

fun main(args: Array<String>) {
    HelloWorld().main(args)
}
