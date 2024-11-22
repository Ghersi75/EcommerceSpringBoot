import { Button } from "./shadcn/button"

interface Props {
  size: string,
  available?: boolean
}

export default function SizeButton({ size, available }: Props) {
  const disabledProps = {
    disabled: true,
    className: "bg-unavailable-size"
  }

  return (
    <Button {...!available && disabledProps}>
      {size.toUpperCase()}
    </Button>
  )
} 