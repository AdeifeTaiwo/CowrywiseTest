package com.example.cowrywisetest.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencySymbolsResponse(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("symbols")
	val symbols: Symbols? = null
) : Parcelable

@Parcelize
data class Symbols(

	@field:SerializedName("FJD")
	val fJD: String? = null,

	@field:SerializedName("MXN")
	val mXN: String? = null,

	@field:SerializedName("STD")
	val sTD: String? = null,

	@field:SerializedName("LVL")
	val lVL: String? = null,

	@field:SerializedName("SCR")
	val sCR: String? = null,

	@field:SerializedName("CDF")
	val cDF: String? = null,

	@field:SerializedName("BBD")
	val bBD: String? = null,

	@field:SerializedName("GTQ")
	val gTQ: String? = null,

	@field:SerializedName("CLP")
	val cLP: String? = null,

	@field:SerializedName("HNL")
	val hNL: String? = null,

	@field:SerializedName("UGX")
	val uGX: String? = null,

	@field:SerializedName("ZAR")
	val zAR: String? = null,

	@field:SerializedName("TND")
	val tND: String? = null,

	@field:SerializedName("SLE")
	val sLE: String? = null,

	@field:SerializedName("CUC")
	val cUC: String? = null,

	@field:SerializedName("BSD")
	val bSD: String? = null,

	@field:SerializedName("SLL")
	val sLL: String? = null,

	@field:SerializedName("SDG")
	val sDG: String? = null,

	@field:SerializedName("IQD")
	val iQD: String? = null,

	@field:SerializedName("CUP")
	val cUP: String? = null,

	@field:SerializedName("GMD")
	val gMD: String? = null,

	@field:SerializedName("TWD")
	val tWD: String? = null,

	@field:SerializedName("RSD")
	val rSD: String? = null,

	@field:SerializedName("DOP")
	val dOP: String? = null,

	@field:SerializedName("KMF")
	val kMF: String? = null,

	@field:SerializedName("MYR")
	val mYR: String? = null,

	@field:SerializedName("FKP")
	val fKP: String? = null,

	@field:SerializedName("XOF")
	val xOF: String? = null,

	@field:SerializedName("GEL")
	val gEL: String? = null,

	@field:SerializedName("BTC")
	val bTC: String? = null,

	@field:SerializedName("UYU")
	val uYU: String? = null,

	@field:SerializedName("MAD")
	val mAD: String? = null,

	@field:SerializedName("CVE")
	val cVE: String? = null,

	@field:SerializedName("TOP")
	val tOP: String? = null,

	@field:SerializedName("AZN")
	val aZN: String? = null,

	@field:SerializedName("OMR")
	val oMR: String? = null,

	@field:SerializedName("PGK")
	val pGK: String? = null,

	@field:SerializedName("KES")
	val kES: String? = null,

	@field:SerializedName("SEK")
	val sEK: String? = null,

	@field:SerializedName("CNH")
	val cNH: String? = null,

	@field:SerializedName("BTN")
	val bTN: String? = null,

	@field:SerializedName("UAH")
	val uAH: String? = null,

	@field:SerializedName("GNF")
	val gNF: String? = null,

	@field:SerializedName("ERN")
	val eRN: String? = null,

	@field:SerializedName("MZN")
	val mZN: String? = null,

	@field:SerializedName("SVC")
	val sVC: String? = null,

	@field:SerializedName("ARS")
	val aRS: String? = null,

	@field:SerializedName("QAR")
	val qAR: String? = null,

	@field:SerializedName("IRR")
	val iRR: String? = null,

	@field:SerializedName("CNY")
	val cNY: String? = null,

	@field:SerializedName("THB")
	val tHB: String? = null,

	@field:SerializedName("UZS")
	val uZS: String? = null,

	@field:SerializedName("XPF")
	val xPF: String? = null,

	@field:SerializedName("MRU")
	val mRU: String? = null,

	@field:SerializedName("BDT")
	val bDT: String? = null,

	@field:SerializedName("LYD")
	val lYD: String? = null,

	@field:SerializedName("BMD")
	val bMD: String? = null,

	@field:SerializedName("KWD")
	val kWD: String? = null,

	@field:SerializedName("PHP")
	val pHP: String? = null,

	@field:SerializedName("RUB")
	val rUB: String? = null,

	@field:SerializedName("PYG")
	val pYG: String? = null,

	@field:SerializedName("ISK")
	val iSK: String? = null,

	@field:SerializedName("JMD")
	val jMD: String? = null,

	@field:SerializedName("COP")
	val cOP: String? = null,

	@field:SerializedName("MKD")
	val mKD: String? = null,

	@field:SerializedName("USD")
	val uSD: String? = null,

	@field:SerializedName("DZD")
	val dZD: String? = null,

	@field:SerializedName("PAB")
	val pAB: String? = null,

	@field:SerializedName("GGP")
	val gGP: String? = null,

	@field:SerializedName("SGD")
	val sGD: String? = null,

	@field:SerializedName("ETB")
	val eTB: String? = null,

	@field:SerializedName("JEP")
	val jEP: String? = null,

	@field:SerializedName("KGS")
	val kGS: String? = null,

	@field:SerializedName("SOS")
	val sOS: String? = null,

	@field:SerializedName("VEF")
	val vEF: String? = null,

	@field:SerializedName("VUV")
	val vUV: String? = null,

	@field:SerializedName("LAK")
	val lAK: String? = null,

	@field:SerializedName("BND")
	val bND: String? = null,

	@field:SerializedName("ZMK")
	val zMK: String? = null,

	@field:SerializedName("XAF")
	val xAF: String? = null,

	@field:SerializedName("LRD")
	val lRD: String? = null,

	@field:SerializedName("XAG")
	val xAG: String? = null,

	@field:SerializedName("CHF")
	val cHF: String? = null,

	@field:SerializedName("HRK")
	val hRK: String? = null,

	@field:SerializedName("ALL")
	val aLL: String? = null,

	@field:SerializedName("DJF")
	val dJF: String? = null,

	@field:SerializedName("VES")
	val vES: String? = null,

	@field:SerializedName("ZMW")
	val zMW: String? = null,

	@field:SerializedName("TZS")
	val tZS: String? = null,

	@field:SerializedName("VND")
	val vND: String? = null,

	@field:SerializedName("XAU")
	val xAU: String? = null,

	@field:SerializedName("AUD")
	val aUD: String? = null,

	@field:SerializedName("ILS")
	val iLS: String? = null,

	@field:SerializedName("GHS")
	val gHS: String? = null,

	@field:SerializedName("GYD")
	val gYD: String? = null,

	@field:SerializedName("KPW")
	val kPW: String? = null,

	@field:SerializedName("BOB")
	val bOB: String? = null,

	@field:SerializedName("KHR")
	val kHR: String? = null,

	@field:SerializedName("MDL")
	val mDL: String? = null,

	@field:SerializedName("IDR")
	val iDR: String? = null,

	@field:SerializedName("KYD")
	val kYD: String? = null,

	@field:SerializedName("AMD")
	val aMD: String? = null,

	@field:SerializedName("BWP")
	val bWP: String? = null,

	@field:SerializedName("SHP")
	val sHP: String? = null,

	@field:SerializedName("TRY")
	val tRY: String? = null,

	@field:SerializedName("LBP")
	val lBP: String? = null,

	@field:SerializedName("TJS")
	val tJS: String? = null,

	@field:SerializedName("JOD")
	val jOD: String? = null,

	@field:SerializedName("AED")
	val aED: String? = null,

	@field:SerializedName("HKD")
	val hKD: String? = null,

	@field:SerializedName("RWF")
	val rWF: String? = null,

	@field:SerializedName("EUR")
	val eUR: String? = null,

	@field:SerializedName("LSL")
	val lSL: String? = null,

	@field:SerializedName("DKK")
	val dKK: String? = null,

	@field:SerializedName("CAD")
	val cAD: String? = null,

	@field:SerializedName("BGN")
	val bGN: String? = null,

	@field:SerializedName("MMK")
	val mMK: String? = null,

	@field:SerializedName("MUR")
	val mUR: String? = null,

	@field:SerializedName("NOK")
	val nOK: String? = null,

	@field:SerializedName("SYP")
	val sYP: String? = null,

	@field:SerializedName("IMP")
	val iMP: String? = null,

	@field:SerializedName("ZWL")
	val zWL: String? = null,

	@field:SerializedName("GIP")
	val gIP: String? = null,

	@field:SerializedName("RON")
	val rON: String? = null,

	@field:SerializedName("LKR")
	val lKR: String? = null,

	@field:SerializedName("NGN")
	val nGN: String? = null,

	@field:SerializedName("CRC")
	val cRC: String? = null,

	@field:SerializedName("CZK")
	val cZK: String? = null,

	@field:SerializedName("PKR")
	val pKR: String? = null,

	@field:SerializedName("XCD")
	val xCD: String? = null,

	@field:SerializedName("ANG")
	val aNG: String? = null,

	@field:SerializedName("HTG")
	val hTG: String? = null,

	@field:SerializedName("BHD")
	val bHD: String? = null,

	@field:SerializedName("KZT")
	val kZT: String? = null,

	@field:SerializedName("SRD")
	val sRD: String? = null,

	@field:SerializedName("SZL")
	val sZL: String? = null,

	@field:SerializedName("LTL")
	val lTL: String? = null,

	@field:SerializedName("SAR")
	val sAR: String? = null,

	@field:SerializedName("TTD")
	val tTD: String? = null,

	@field:SerializedName("YER")
	val yER: String? = null,

	@field:SerializedName("MVR")
	val mVR: String? = null,

	@field:SerializedName("AFN")
	val aFN: String? = null,

	@field:SerializedName("INR")
	val iNR: String? = null,

	@field:SerializedName("AWG")
	val aWG: String? = null,

	@field:SerializedName("KRW")
	val kRW: String? = null,

	@field:SerializedName("NPR")
	val nPR: String? = null,

	@field:SerializedName("JPY")
	val jPY: String? = null,

	@field:SerializedName("MNT")
	val mNT: String? = null,

	@field:SerializedName("AOA")
	val aOA: String? = null,

	@field:SerializedName("PLN")
	val pLN: String? = null,

	@field:SerializedName("GBP")
	val gBP: String? = null,

	@field:SerializedName("SBD")
	val sBD: String? = null,

	@field:SerializedName("BYN")
	val bYN: String? = null,

	@field:SerializedName("HUF")
	val hUF: String? = null,

	@field:SerializedName("BYR")
	val bYR: String? = null,

	@field:SerializedName("BIF")
	val bIF: String? = null,

	@field:SerializedName("MWK")
	val mWK: String? = null,

	@field:SerializedName("MGA")
	val mGA: String? = null,

	@field:SerializedName("XDR")
	val xDR: String? = null,

	@field:SerializedName("BZD")
	val bZD: String? = null,

	@field:SerializedName("BAM")
	val bAM: String? = null,

	@field:SerializedName("EGP")
	val eGP: String? = null,

	@field:SerializedName("MOP")
	val mOP: String? = null,

	@field:SerializedName("NAD")
	val nAD: String? = null,

	@field:SerializedName("NIO")
	val nIO: String? = null,

	@field:SerializedName("PEN")
	val pEN: String? = null,

	@field:SerializedName("NZD")
	val nZD: String? = null,

	@field:SerializedName("WST")
	val wST: String? = null,

	@field:SerializedName("TMT")
	val tMT: String? = null,

	@field:SerializedName("CLF")
	val cLF: String? = null,

	@field:SerializedName("BRL")
	val bRL: String? = null
) : Parcelable
