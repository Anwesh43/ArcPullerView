package com.anwesh.uiprojects.arcpullerview

/**
 * Created by anweshmishra on 18/11/19.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Canvas
import android.graphics.Color

val nodes : Int = 5
val scGap : Float = 0.02f
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#673AB7")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify(n : Int) : Float = Math.sin(this * (Math.PI / n)).toFloat()
fun Float.cosify() : Float = 1f - Math.sin(Math.PI / 2 + (Math.PI / 2) * this).toFloat()
fun Float.toFrom(s : Float, d : Float) : Float = s + (d - s) * this

fun Canvas.drawArcPuller(size : Float, scale : Float, h : Float, paint : Paint) {
    val sc1 : Float = scale.divideScale(0, 2).sinify(2)
    val sf : Float = scale.divideScale(1, 2).sinify(1)
    val sc2 : Float = scale.divideScale(1, 2).cosify()
    save()
    translate(0f, size + (h - 2 * size) * sc2)
    drawArc(RectF(-size, -size, size, size), 0f, 360f * sc1, true, paint)
    restore()
    drawLine(0f, h - size, 0f, sf.toFrom(h - size, size), paint)
}

fun Canvas.drawAPNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(gap * (i + 1), 0f)
    drawArcPuller(size, scale, h, paint)
    restore()
}

class ArcPullerView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}