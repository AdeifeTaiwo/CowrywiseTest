package com.example.cowrywisetest.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyRateResponse(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("rates")
	val rates: Rates? = null,

	@field:SerializedName("timestamp")
	val timestamp: Int? = null,

	@field:SerializedName("base")
	val base: String? = null
) : Parcelable

@Parcelize
data class Rates(
	@field:SerializedName("FJD")
	val fJD:Double? = null,

	@field:SerializedName("MXN")
	val mXN: Double? = null,

	@field:SerializedName("STD")
	val sTD: Double? = null,

	@field:SerializedName("LVL")
	val lVL: Double? = null,

	@field:SerializedName("SCR")
	val sCR: Double? = null,

	@field:SerializedName("CDF")
	val cDF: Double? = null,

	@field:SerializedName("BBD")
	val bBD: Double? = null,

	@field:SerializedName("GTQ")
	val gTQ: Double? = null,

	@field:SerializedName("CLP")
	val cLP: Double? = null,

	@field:SerializedName("HNL")
	val hNL: Double? = null,

	@field:SerializedName("UGX")
	val uGX: Double? = null,

	@field:SerializedName("ZAR")
	val zAR: Double? = null,

	@field:SerializedName("TND")
	val tND: Double? = null,

	@field:SerializedName("SLE")
	val sLE: Double? = null,

	@field:SerializedName("CUC")
	val cUC: Double? = null,

	@field:SerializedName("BSD")
	val bSD: Double? = null,

	@field:SerializedName("SLL")
	val sLL: Double? = null,

	@field:SerializedName("SDG")
	val sDG: Double? = null,

	@field:SerializedName("IQD")
	val iQD: Double? = null,

	@field:SerializedName("CUP")
	val cUP: Double? = null,

	@field:SerializedName("GMD")
	val gMD: Double? = null,

	@field:SerializedName("TWD")
	val tWD: Double? = null,

	@field:SerializedName("RSD")
	val rSD: Double? = null,

	@field:SerializedName("DOP")
	val dOP: Double? = null,

	@field:SerializedName("KMF")
	val kMF: Double? = null,

	@field:SerializedName("MYR")
	val mYR: Double? = null,

	@field:SerializedName("FKP")
	val fKP: Double? = null,

	@field:SerializedName("XOF")
	val xOF: Double? = null,

	@field:SerializedName("GEL")
	val gEL: Double? = null,

	@field:SerializedName("BTC")
	val bTC: Double? = null,

	@field:SerializedName("UYU")
	val uYU: Double? = null,

	@field:SerializedName("MAD")
	val mAD: Double? = null,

	@field:SerializedName("CVE")
	val cVE: Double? = null,

	@field:SerializedName("TOP")
	val tOP: Double? = null,

	@field:SerializedName("AZN")
	val aZN: Double? = null,

	@field:SerializedName("OMR")
	val oMR: Double? = null,

	@field:SerializedName("PGK")
	val pGK: Double? = null,

	@field:SerializedName("KES")
	val kES: Double? = null,

	@field:SerializedName("SEK")
	val sEK: Double? = null,

	@field:SerializedName("CNH")
	val cNH: Double? = null,

	@field:SerializedName("BTN")
	val bTN: Double? = null,

	@field:SerializedName("UAH")
	val uAH: Double? = null,

	@field:SerializedName("GNF")
	val gNF: Double? = null,

	@field:SerializedName("ERN")
	val eRN: Double? = null,

	@field:SerializedName("MZN")
	val mZN: Double? = null,

	@field:SerializedName("SVC")
	val sVC: Double? = null,

	@field:SerializedName("ARS")
	val aRS: Double? = null,

	@field:SerializedName("QAR")
	val qAR: Double? = null,

	@field:SerializedName("IRR")
	val iRR: Double? = null,

	@field:SerializedName("CNY")
	val cNY: Double? = null,

	@field:SerializedName("THB")
	val tHB: Double? = null,

	@field:SerializedName("UZS")
	val uZS: Double? = null,

	@field:SerializedName("XPF")
	val xPF: Double? = null,

	@field:SerializedName("MRU")
	val mRU: Double? = null,

	@field:SerializedName("BDT")
	val bDT: Double? = null,

	@field:SerializedName("LYD")
	val lYD: Double? = null,

	@field:SerializedName("BMD")
	val bMD: Double? = null,

	@field:SerializedName("KWD")
	val kWD: Double? = null,

	@field:SerializedName("PHP")
	val pHP: Double? = null,

	@field:SerializedName("RUB")
	val rUB: Double? = null,

	@field:SerializedName("PYG")
	val pYG: Double? = null,

	@field:SerializedName("ISK")
	val iSK: Double? = null,

	@field:SerializedName("JMD")
	val jMD: Double? = null,

	@field:SerializedName("COP")
	val cOP: Double? = null,

	@field:SerializedName("MKD")
	val mKD: Double? = null,

	@field:SerializedName("USD")
	val uSD: Double? = null,

	@field:SerializedName("DZD")
	val dZD: Double? = null,

	@field:SerializedName("PAB")
	val pAB: Double? = null,

	@field:SerializedName("GGP")
	val gGP: Double? = null,

	@field:SerializedName("SGD")
	val sGD: Double? = null,

	@field:SerializedName("ETB")
	val eTB: Double? = null,

	@field:SerializedName("JEP")
	val jEP: Double? = null,

	@field:SerializedName("KGS")
	val kGS: Double? = null,

	@field:SerializedName("SOS")
	val sOS: Double? = null,

	@field:SerializedName("VUV")
	val vUV: Double? = null,

	@field:SerializedName("LAK")
	val lAK: Double? = null,

	@field:SerializedName("BND")
	val bND: Double? = null,

	@field:SerializedName("ZMK")
	val zMK: Double? = null,

	@field:SerializedName("XAF")
	val xAF: Double? = null,

	@field:SerializedName("LRD")
	val lRD: Double? = null,

	@field:SerializedName("XAG")
	val xAG: Double? = null,

	@field:SerializedName("CHF")
	val cHF: Double? = null,

	@field:SerializedName("HRK")
	val hRK: Double? = null,

	@field:SerializedName("ALL")
	val aLL: Double? = null,

	@field:SerializedName("DJF")
	val dJF: Double? = null,

	@field:SerializedName("VES")
	val vES: Double? = null,

	@field:SerializedName("ZMW")
	val zMW: Double? = null,

	@field:SerializedName("TZS")
	val tZS: Double? = null,

	@field:SerializedName("VND")
	val vND: Double? = null,

	@field:SerializedName("XAU")
	val xAU: Double? = null,

	@field:SerializedName("AUD")
	val aUD: Double? = null,

	@field:SerializedName("ILS")
	val iLS: Double? = null,

	@field:SerializedName("GHS")
	val gHS: Double? = null,

	@field:SerializedName("GYD")
	val gYD: Double? = null,

	@field:SerializedName("KPW")
	val kPW: Double? = null,

	@field:SerializedName("BOB")
	val bOB: Double? = null,

	@field:SerializedName("KHR")
	val kHR: Double? = null,

	@field:SerializedName("MDL")
	val mDL: Double? = null,

	@field:SerializedName("IDR")
	val iDR: Double? = null,

	@field:SerializedName("KYD")
	val kYD: Double? = null,

	@field:SerializedName("AMD")
	val aMD: Double? = null,

	@field:SerializedName("BWP")
	val bWP: Double? = null,

	@field:SerializedName("SHP")
	val sHP: Double? = null,

	@field:SerializedName("TRY")
	val tRY: Double? = null,

	@field:SerializedName("LBP")
	val lBP: Double? = null,

	@field:SerializedName("TJS")
	val tJS: Double? = null,

	@field:SerializedName("JOD")
	val jOD: Double? = null,

	@field:SerializedName("AED")
	val aED: Double? = null,

	@field:SerializedName("HKD")
	val hKD: Double? = null,

	@field:SerializedName("RWF")
	val rWF: Double? = null,

	@field:SerializedName("EUR")
	val eUR: Double? = null,

	@field:SerializedName("LSL")
	val lSL: Double? = null,

	@field:SerializedName("DKK")
	val dKK: Double? = null,

	@field:SerializedName("CAD")
	val cAD: Double? = null,

	@field:SerializedName("BGN")
	val bGN: Double? = null,

	@field:SerializedName("MMK")
	val mMK: Double? = null,

	@field:SerializedName("MUR")
	val mUR: Double? = null,

	@field:SerializedName("NOK")
	val nOK: Double? = null,

	@field:SerializedName("SYP")
	val sYP: Double? = null,

	@field:SerializedName("IMP")
	val iMP: Double? = null,

	@field:SerializedName("ZWL")
	val zWL: Double? = null,

	@field:SerializedName("GIP")
	val gIP: Double? = null,

	@field:SerializedName("RON")
	val rON: Double? = null,

	@field:SerializedName("LKR")
	val lKR: Double? = null,

	@field:SerializedName("NGN")
	val nGN: Double? = null,

	@field:SerializedName("CRC")
	val cRC: Double? = null,

	@field:SerializedName("CZK")
	val cZK: Double? = null,

	@field:SerializedName("PKR")
	val pKR: Double? = null,

	@field:SerializedName("XCD")
	val xCD: Double? = null,

	@field:SerializedName("ANG")
	val aNG: Double? = null,

	@field:SerializedName("HTG")
	val hTG: Double? = null,

	@field:SerializedName("BHD")
	val bHD: Double? = null,

	@field:SerializedName("KZT")
	val kZT: Double? = null,

	@field:SerializedName("SRD")
	val sRD: Double? = null,

	@field:SerializedName("SZL")
	val sZL: Double? = null,

	@field:SerializedName("LTL")
	val lTL: Double? = null,

	@field:SerializedName("SAR")
	val sAR: Double? = null,

	@field:SerializedName("TTD")
	val tTD: Double? = null,

	@field:SerializedName("YER")
	val yER: Double? = null,

	@field:SerializedName("MVR")
	val mVR: Double? = null,

	@field:SerializedName("AFN")
	val aFN: Double? = null,

	@field:SerializedName("INR")
	val iNR: Double? = null,

	@field:SerializedName("AWG")
	val aWG: Double? = null,

	@field:SerializedName("KRW")
	val kRW: Double? = null,

	@field:SerializedName("NPR")
	val nPR: Double? = null,

	@field:SerializedName("JPY")
	val jPY: Double? = null,

	@field:SerializedName("MNT")
	val mNT: Double? = null,

	@field:SerializedName("AOA")
	val aOA: Double? = null,

	@field:SerializedName("PLN")
	val pLN: Double? = null,

	@field:SerializedName("GBP")
	val gBP: Double? = null,

	@field:SerializedName("SBD")
	val sBD: Double? = null,

	@field:SerializedName("BYN")
	val bYN: Double? = null,

	@field:SerializedName("HUF")
	val hUF: Double? = null,

	@field:SerializedName("BYR")
	val bYR: Double? = null,

	@field:SerializedName("BIF")
	val bIF: Double? = null,

	@field:SerializedName("MWK")
	val mWK: Double? = null,

	@field:SerializedName("MGA")
	val mGA: Double? = null,

	@field:SerializedName("XDR")
	val xDR: Double? = null,

	@field:SerializedName("BZD")
	val bZD: Double? = null,

	@field:SerializedName("BAM")
	val bAM: Double? = null,

	@field:SerializedName("EGP")
	val eGP: Double? = null,

	@field:SerializedName("MOP")
	val mOP: Double? = null,

	@field:SerializedName("NAD")
	val nAD: Double? = null,

	@field:SerializedName("NIO")
	val nIO: Double? = null,

	@field:SerializedName("PEN")
	val pEN: Double? = null,

	@field:SerializedName("NZD")
	val nZD: Double? = null,

	@field:SerializedName("WST")
	val wST: Double? = null,

	@field:SerializedName("TMT")
	val tMT: Double? = null,

	@field:SerializedName("CLF")
	val cLF: Double? = null,

	@field:SerializedName("BRL")
	val bRL: Double? = null
) : Parcelable




