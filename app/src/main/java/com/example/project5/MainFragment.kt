package com.example.project5
/**
 * First, accesses necessary Views from layout
 * Secondly instantiates each type of translator from google MLKit
 * Then sets a watcher for input text, to translate and update text whenever input text is changed
 */
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.*
import org.w3c.dom.Text


class MainFragment : Fragment() {

//This is the starting screen.
    // It allows the user to select the number of questions, the difficulty, and the type of operation.
    // pressing start takes the user to the next screen.


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val inputTextView = view.findViewById<EditText>(R.id.editTextText)
        val sourceEnglish = view.findViewById<RadioButton>(R.id.English)
        val sourceSpanish = view.findViewById<RadioButton>(R.id.Spanish)
        val sourceGerman = view.findViewById<RadioButton>(R.id.German)
        val translationSpanish = view.findViewById<RadioButton>(R.id.Spanish1)
        val translationGerman = view.findViewById<RadioButton>(R.id.German1)
        val translationEnglish = view.findViewById<RadioButton>(R.id.English1)
        val translatedTextView = view.findViewById<TextView>(R.id.textView8)
        var sourceText = ""

        //English to Spanish

        var options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.SPANISH)
            .build()
        val englishSpanishTranslator = Translation.getClient(options)
        var conditions = DownloadConditions.Builder()
            .build()
        englishSpanishTranslator.downloadModelIfNeeded(conditions)

        //English to German

        options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.GERMAN)
            .build()
        val englishGermanTranslator = Translation.getClient(options)
         conditions = DownloadConditions.Builder()
            .build()
        englishGermanTranslator.downloadModelIfNeeded(conditions)

        //German to English
        options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.GERMAN)
            .setTargetLanguage(TranslateLanguage.ENGLISH)
            .build()
        val germanEnglishTranslator = Translation.getClient(options)
        conditions = DownloadConditions.Builder()
            .build()
        germanEnglishTranslator.downloadModelIfNeeded(conditions)

        //German to Spanish
        options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.GERMAN)
            .setTargetLanguage(TranslateLanguage.SPANISH)
            .build()
        val germanSpanishTranslator = Translation.getClient(options)
        conditions = DownloadConditions.Builder()
            .build()
        germanSpanishTranslator.downloadModelIfNeeded(conditions)

        //Spanish to English
        options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.SPANISH)
            .setTargetLanguage(TranslateLanguage.ENGLISH)
            .build()
        val spanishEnglishTranslator = Translation.getClient(options)
        conditions = DownloadConditions.Builder()
            .build()
        spanishEnglishTranslator.downloadModelIfNeeded(conditions)

        //Spanish to German
        options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.SPANISH)
            .setTargetLanguage(TranslateLanguage.GERMAN)
            .build()
        val spanishGermanTranslator = Translation.getClient(options)
        conditions = DownloadConditions.Builder()
            .build()
        spanishGermanTranslator.downloadModelIfNeeded(conditions)

// setting the listener for the input text
        inputTextView.addTextChangedListener(object : TextWatcher {
            //overriding functions for textWatcher
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                if (sourceEnglish.isChecked) {
                    if (translationSpanish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        englishSpanishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationGerman.isChecked) {
                        sourceText = inputTextView.text.toString()
                        englishGermanTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationEnglish.isChecked) {
                        translatedTextView.text = inputTextView.text

                    }


                }
                if (sourceGerman.isChecked) {
                    if (translationSpanish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        germanSpanishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationGerman.isChecked) {
                        translatedTextView.text = inputTextView.text

                    }
                    if (translationEnglish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        germanEnglishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }


                }
                if (sourceSpanish.isChecked) {
                    if (translationSpanish.isChecked) {
                        translatedTextView.text = inputTextView.text
                    }
                    if (translationGerman.isChecked) {
                        sourceText = inputTextView.text.toString()
                        spanishGermanTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationEnglish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        spanishEnglishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }
                    }
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                //checks what the source language is, then checks the translation language

                if (sourceEnglish.isChecked) {
                    if (translationSpanish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        englishSpanishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationGerman.isChecked) {
                        sourceText = inputTextView.text.toString()
                        englishGermanTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationEnglish.isChecked) {
                        translatedTextView.text = inputTextView.text

                    }


                }
                if (sourceGerman.isChecked) {
                    if (translationSpanish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        germanSpanishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationGerman.isChecked) {
                        translatedTextView.text = inputTextView.text

                    }
                    if (translationEnglish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        germanEnglishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }


                }
                if (sourceSpanish.isChecked) {
                    if (translationSpanish.isChecked) {
                        translatedTextView.text = inputTextView.text
                    }
                    if (translationGerman.isChecked) {
                        sourceText = inputTextView.text.toString()
                        spanishGermanTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationEnglish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        spanishEnglishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }


                }
            }

            override fun afterTextChanged(s: Editable?) {

                if (sourceEnglish.isChecked) {
                    if (translationSpanish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        englishSpanishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationGerman.isChecked) {
                        sourceText = inputTextView.text.toString()
                        englishGermanTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationEnglish.isChecked) {
                        translatedTextView.text = inputTextView.text

                    }


                }
                if (sourceGerman.isChecked) {
                    if (translationSpanish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        germanSpanishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationGerman.isChecked) {
                        translatedTextView.text = inputTextView.text

                    }
                    if (translationEnglish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        germanEnglishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }


                }
                if (sourceSpanish.isChecked) {
                    if (translationSpanish.isChecked) {
                        translatedTextView.text = inputTextView.text
                    }
                    if (translationGerman.isChecked) {
                        sourceText = inputTextView.text.toString()
                        spanishGermanTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }
                    if (translationEnglish.isChecked) {
                        sourceText = inputTextView.text.toString()
                        spanishEnglishTranslator.translate(sourceText)
                            .addOnSuccessListener { translatedText ->
                                translatedTextView.text = translatedText
                            }

                    }


                }
            }
        })


        return view
    }
    }


