import Link from "next/link"
import { ModeToggle } from "./shadcn/modeToggle"

export default function Navbar() {
  return (
    <nav className="bg-background text-foreground border-b border-border">
      <div className="mx-auto px-4 sm:px-6 lg:px-8 flex justify-between items-center h-16">
        <div className="flex-shrink-0">
          <Link href="/" className="text-primary font-semibold">
            Logo
          </Link>
        </div>
        <div className="flex space-x-4">
          <ModeToggle />
        </div>
      </div>
    </nav>
  )
}
