package com.multimodule.api.controller.mockito_kotlintest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentMatchers
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.util.*

internal class KotlinTest {
    @Test
    fun `mock_will_memorize_all_interaction`(){
        val mockList = mock<MutableList<String>>()

        mockList.add("1")
        mockList.clear()

        verify(mockList).add("1")
        verify(mockList).clear()

    }

    @Test
    fun `how to stubbing`() {
        // interface 뿐 아니라 구체 클래스도 mock으로 만들 수 있습니다.
        val mockedList = mock<LinkedList<String>>()


        //stubbing
        whenever(mockedList[0]).thenReturn("first")
        whenever(mockedList[1]).thenThrow(RuntimeException())


        println(mockedList[0])  //첫 번째 element를 출력합니다.
//        println(mockedList[1])  //RuntimeException occurred
        println(mockedList[999]) //999 element는 stub 되지않았으므로 null 출력합니다.

        assertThrows<RuntimeException> {
            mockedList[1]
        }

        // stubbing 된 부분이 호출되는지 확인할 수 있긴 하지만 불필요한 일입니다.
        // 만일 코드에서 get(0)의 리턴값을 확인하려고 하면, 다른 어딘가에서 테스트가 깨집니다.
        // 만일 코드에서 get(0)의 리턴값에 대해 관심이 없다면, stubbing되지 않았어야 합니다.
//        verify(mockedList)[0]
    }

    @Test
    fun `argument_matcher`() {
        val mockedStringList =
            mock<LinkedList<String>>()  //val mockedIntList:LinkedList<Int> = mock()

        val mockedFloatList = mock<LinkedList<Float>> {
            on { this[ArgumentMatchers.anyInt()] } doReturn 3f
        }

        //내장된 argument matcher인 anyInt()를 이용한 stubbing
        // 모든 Integer 타입 매개변수를 받을 경우 "element"를 돌려줍니다.
        whenever(mockedStringList[ArgumentMatchers.anyInt()]).thenReturn("elements")

        println(mockedStringList[2])
        println(mockedFloatList[3])
        println(mockedFloatList[3])

        assertThat(mockedFloatList[1]).isEqualTo(1f)


    }
}