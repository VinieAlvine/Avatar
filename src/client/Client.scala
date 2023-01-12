package client

import library._
import automaticTester.TestAvatar
import implementations.MyMachineDialogue

object Client extends App {
	TestAvatar.check(MyMachineDialogue)
}
