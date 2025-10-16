package ch.shaunbur.switchkraft

interface EditableFieldHandle {
    fun validate(): Boolean
    fun revert()
}