package com.example.travels_map.presentation.utils

import android.graphics.*
import android.text.TextPaint
import android.text.TextUtils
import com.example.travels_map.R
import com.example.travels_map.presentation.TravelsMapApplication

object MapUtils {

    private val context = TravelsMapApplication.INSTANCE

    object Waypoint {
        private const val fullSize = 56
        private const val padding = 8
        private const val center = fullSize / 2f

        private const val size = fullSize - padding
        private const val radius = size / 2f

        private val textRect: Rect = Rect()

        private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            style = Paint.Style.FILL
        }

        private val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
            strokeWidth = Metrics.convertDpToPixel(2f, context)
            isDither = true
        }

        private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.BLACK
            textSize = Metrics.convertDpToPixel(12f, context)
            textAlign = Paint.Align.CENTER
            typeface = Typeface.DEFAULT_BOLD
        }

        fun drawBitmap(text: String): Bitmap {
            val bitmap = Bitmap.createBitmap(fullSize, fullSize, Bitmap.Config.ARGB_8888)

            Canvas(bitmap).apply {
                drawCircle(center, center, radius, backgroundPaint)
                drawCircle(center, center, radius, borderPaint)
                drawText(
                    text,
                    center,
                    center + getTextHeight(text, textPaint, textRect) / 2,
                    textPaint,
                )
            }
            return bitmap
        }
    }

    object Place {
        private const val fullSize = 128
        private const val padding = 8
        private const val center = fullSize / 2f

        private const val size = fullSize - padding
        private const val radius = size / 2f

        private val textRect: Rect = Rect()

        private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = context.getColor(R.color.blue_de_france)
            style = Paint.Style.FILL
        }

        private val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = context.getColor(R.color.boeing_blue)
            style = Paint.Style.STROKE
            strokeWidth = Metrics.convertDpToPixel(2f, context)
            isDither = true
        }

        private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.BLACK
            textSize = Metrics.convertDpToPixel(32f, context)
            textAlign = Paint.Align.CENTER
            typeface = Typeface.DEFAULT
            strokeJoin = Paint.Join.ROUND
            strokeMiter = 10f
            strokeWidth = Metrics.convertDpToPixel(1f, context)
        }

        fun drawBitmap(text: String): Bitmap {
            val bitmap = Bitmap.createBitmap(fullSize, fullSize, Bitmap.Config.ARGB_8888)
            val calculatedText = TextUtils.ellipsize(
                text,
                textPaint,
                fullSize.toFloat(),
                TextUtils.TruncateAt.END,
            )

            Canvas(bitmap).apply {
                drawCircle(center, center, radius, backgroundPaint)
                drawCircle(center, center, radius, borderPaint)
                drawText(
                    calculatedText.toString(),
                    center,
                    center + getTextHeight(text, textPaint, textRect) / 2,
                    textPaint,
                )
            }
            return bitmap
        }
    }

    private fun getTextHeight(text: String, paint: Paint, textRect: Rect): Float {
        paint.getTextBounds(text, 0, text.length, textRect)
        return textRect.height().toFloat()
    }
}