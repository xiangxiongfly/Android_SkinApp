package com.example.plugin_skin.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment {

    constructor() : super()

    constructor(@LayoutRes layoutId: Int) : super(layoutId)
}