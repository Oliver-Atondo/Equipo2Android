package com.desswapp.module4eqp2.excercise.home.fernando_hernandez.exercise2

data class ComponentsUsing(
    var editText: Int,
    var button: Int,
    var textView: Int,
    var checkBox: Int,
    var radioButton: Int,
    var spinner: Int,
    var image: Int,
    var imageButton: Int,
)

fun ComponentsUsing.setEditText(value: Int) {
    this.editText = value
}
fun ComponentsUsing.setButton(value: Int) {
    this.button = value
}
fun ComponentsUsing.setTextView(value: Int) {
    this.textView = value
}
fun ComponentsUsing.setCheckBox(value: Int) {
    this.checkBox = value
}
fun ComponentsUsing.setRadioButton(value: Int) {
    this.radioButton = value
}
fun ComponentsUsing.setSpinner(value: Int) {
    this.spinner = value
    }
fun ComponentsUsing.setImage(value: Int) {
    this.image = value
}
fun ComponentsUsing.setImageButton(value: Int) {
    this.imageButton = value
}

fun ComponentsUsing.getEditText(): Int {
    return this.editText
}
fun ComponentsUsing.getButton(): Int {
    return this.button
}
fun ComponentsUsing.getTextView(): Int {
    return this.textView
}
fun ComponentsUsing.getCheckBox(): Int {
    return this.checkBox
}
fun ComponentsUsing.getRadioButton(): Int {
    return this.radioButton
}
fun ComponentsUsing.getSpinner(): Int {
    return this.spinner
}
fun ComponentsUsing.getImage(): Int {
    return this.image
}
fun ComponentsUsing.getImageButton(): Int {
    return this.imageButton
}
